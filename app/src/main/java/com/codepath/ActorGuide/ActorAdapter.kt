package com.codepath.ActorGuide

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


const val ACTOR_EXTRA = "ACTOR_EXTRA"
private const val TAG = "ActorAdapter"

class ActorAdapter(private val context: Context, private val actors: List<Actor>) :
    RecyclerView.Adapter<ActorAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_article, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val actor = actors[position]
        holder.bind(actor)
        // TODO: Get the individual article and bind to holder
    }

    override fun getItemCount() = actors.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        private val mediaImageView = itemView.findViewById<ImageView>(R.id.mediaImage)
        private val titleTextView = itemView.findViewById<TextView>(R.id.mediaTitle)
        //private val abstractTextView = itemView.findViewById<TextView>(R.id.mediaAbstract)

        init {
            itemView.setOnClickListener(this)
        }

        // TODO: Write a helper method to help set up the onBindViewHolder method
        fun bind(actor: Actor) {
           // val picture ="https://image.tmdb.org/t/p/w500"
            //val actor = actors[position]
            titleTextView.text = actor.name
          // abstractTextView.text = actor.overview
            //mediaImageView.ImageView = actor.mediaImageUrl

            Glide.with(context)
                .load(  actor.mediaImageUrl)
                .into(mediaImageView)
        }
        override fun onClick(v: View?) {
            // TODO: Get selected actor
            var actor = actors[absoluteAdapterPosition]
            // TODO: Navigate to Details screen and pass selected actor
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(ACTOR_EXTRA, actor)
            context.startActivity(intent)
        }
    }
}