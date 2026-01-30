package com.example.assignment2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class StoryAdapter : RecyclerView.Adapter<StoryAdapter.StoryViewHolder>() {

    // Updated with all usernames including "malaika"
    private val stories = listOf(
        "Your Story",
        "dareesha",
        "zara",
        "zoha",
        "alyba",
        "malaika"
    )

    class StoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val storyImage: CircleImageView = view.findViewById(R.id.story_image)
        val username: TextView = view.findViewById(R.id.story_username)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_story, parent, false)
        return StoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        val username = stories[position]
        holder.username.text = username

        // Assign images to each story
        when (position) {
            0 -> holder.storyImage.setImageResource(R.drawable.mypicture)   // Your Story - use mypicture
            1 -> holder.storyImage.setImageResource(R.drawable.dareesha)    // dareesha
            2 -> holder.storyImage.setImageResource(R.drawable.zara)        // zara
            3 -> holder.storyImage.setImageResource(R.drawable.zoha)        // zoha
            4 -> holder.storyImage.setImageResource(R.drawable.alyba)       // alyba
            5 -> holder.storyImage.setImageResource(R.drawable.malaika)     // malaika
        }

        // Style for "Your Story" - different border
        if (position == 0) {
            holder.storyImage.borderWidth = 3
            holder.storyImage.borderColor = holder.itemView.context.getColor(android.R.color.white)
        } else {
            holder.storyImage.borderWidth = 2
            holder.storyImage.borderColor = holder.itemView.context.getColor(android.R.color.holo_red_light)
        }

        // Add click listener for stories - FIXED Toast message
        holder.itemView.setOnClickListener {
            val message = if (position == 0) {
                "View your story"
            } else {
                "View $username's story"
            }
            Toast.makeText(holder.itemView.context, message, Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount() = stories.size
}