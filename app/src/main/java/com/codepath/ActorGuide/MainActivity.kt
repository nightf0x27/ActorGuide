package com.codepath.ActorGuide

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codepath.ActorGuide.databinding.ActivityMainBinding
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import kotlinx.serialization.json.Json
import okhttp3.Headers
import org.json.JSONException

fun createJson() = Json {
    isLenient = true
    ignoreUnknownKeys = true
    useAlternativeNames = false
}

private const val TAG = "MainActivity/"
private const val SEARCH_API_KEY =  BuildConfig.API_KEY
private const val ACTOR_SEARCH_URL =
    "https://api.themoviedb.org/3/person/popular?api_key=${SEARCH_API_KEY}"

class MainActivity : AppCompatActivity() {
    private lateinit var actorsRecyclerView: RecyclerView
    private lateinit var binding: ActivityMainBinding
    private val actors = mutableListOf<Actor>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val actorAdapter = ActorAdapter(this, actors)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        actorsRecyclerView = findViewById(R.id.articles)
        // TODO: Set up ArticleAdapter with articles
        actorsRecyclerView.adapter = actorAdapter
        actorsRecyclerView.layoutManager = LinearLayoutManager(this).also {
            val dividerItemDecoration = DividerItemDecoration(this, it.orientation)
            actorsRecyclerView.addItemDecoration(dividerItemDecoration)
        }

        val client = AsyncHttpClient()
        client.get(ACTOR_SEARCH_URL, object : JsonHttpResponseHandler() {
            override fun onFailure(
                statusCode: Int,
                headers: Headers?,
                response: String?,
                throwable: Throwable?
            ) {
                Log.e(TAG, "Failed to fetch articles: $statusCode")
            }

            override fun onSuccess(statusCode: Int, headers: Headers, json: JSON) {
                Log.i(TAG, "Successfully fetched articles: $json")
                try {
                    // TODO: Create the parsedJSON
                    val parsedJson = createJson().decodeFromString(
                        SearchActor.serializer(),
                        json.jsonObject.toString()
                    )
                    // TODO: Do something with the returned json (contains article information)
                    parsedJson.results?.let { list ->
                        actors.addAll(list)
                    }
                    // TODO: Save the articles and reload the screen
                    actorAdapter.notifyDataSetChanged()
                } catch (e: JSONException) {
                    Log.e(TAG, "Exception: $e")
                }
            }

        })

    }
}