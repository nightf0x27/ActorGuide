package com.codepath.ActorGuide

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide


private const val TAG = "DetailActivity"

class DetailActivity : AppCompatActivity() {
    private lateinit var mediaImageView: ImageView
    private lateinit var titleTextView: TextView
    private lateinit var bylineTextView: TextView
    private lateinit var abstractTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // TODO: Find the views for the screen
        mediaImageView = findViewById(R.id.mediaImage)
        titleTextView = findViewById(R.id.mediaTitle)
        bylineTextView = findViewById(R.id.mediaByline)
        abstractTextView = findViewById(R.id.mediaAbstract)
        // TODO: Get the extra from the Intent
        val actor = intent.getSerializableExtra(ACTOR_EXTRA) as Actor
        // TODO: Set the title, byline, and abstract information from the article
        titleTextView.text = actor.image
       // bylineTextView.text = OneOf(Ac).title
        abstractTextView.text = actor.mediaImageUrl
        // TODO: Load the media image
        Glide.with(this)
            .load(actor.mediaImageUrl)
            .into(mediaImageView)
    }
}