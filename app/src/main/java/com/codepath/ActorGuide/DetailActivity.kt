package com.codepath.ActorGuide

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide


private const val TAG = "DetailActivity"

class DetailActivity : AppCompatActivity() {
    private lateinit var mediaImageView: ImageView
    private lateinit var nameTextView: TextView
    private lateinit var overviewTextView: TextView
    private lateinit var voteCountTextView: TextView
    private lateinit var firstAirTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // TODO: Find the views for the screen
        mediaImageView = findViewById(R.id.posterPath)
        nameTextView = findViewById(R.id.ActorName)
        overviewTextView = findViewById(R.id.overview)
        voteCountTextView = findViewById(R.id.voteCount)
        firstAirTextView = findViewById(R.id.firstAir)
        // TODO: Get the extra from the Intent
        val actor = intent.getSerializableExtra(ACTOR_EXTRA) as Actor
        // TODO: Set the name, title and overview information from the movie
        nameTextView.text = actor.name
        overviewTextView.text = actor.overview
        voteCountTextView.text = actor.voteCount.toString()
        firstAirTextView.text = actor.firstAir
      //  mediaImageView.id
        // TODO: Load the media image
       // val picture = "https://image.tmdb.org/t/p/w500"
        Glide.with(this)
            .load(actor.mediaImageUrl)
            .into(mediaImageView)
    }
}