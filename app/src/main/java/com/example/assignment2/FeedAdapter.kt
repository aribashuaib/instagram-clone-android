package com.example.assignment2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView

// Data class for feed items
data class FeedItem(
    val id: Int,
    val username: String,
    val profileImageRes: Int = R.drawable.dareesha,
    val postImageRes: Int = R.drawable.zoha,
    val likes: Int,
    val caption: String,
    val comments: Int,
    val timeAgo: String,
    var isLiked: Boolean = false,
    var isSaved: Boolean = false
)

class FeedAdapter : RecyclerView.Adapter<FeedAdapter.FeedViewHolder>() {

    // Sample feed data with 10 items to ensure scrolling
    private val feedItems = mutableListOf(
        FeedItem(
            id = 1,
            username = "zoha",
            profileImageRes = R.drawable.dareesha,
            postImageRes = R.drawable.zoha,
            likes = 287,
            caption = "Qawali Night",
            comments = 42,
            timeAgo = "2 HOURS AGO"
        ),
        FeedItem(
            id = 2,
            username = "zara",
            profileImageRes = R.drawable.zara,
            postImageRes = R.drawable.alyba,
            likes = 512,
            caption = "City lights never sleep 🌃",
            comments = 89,
            timeAgo = "5 HOURS AGO"
        ),
        FeedItem(
            id = 3,
            username = "zoha",
            profileImageRes = R.drawable.zoha,
            postImageRes = R.drawable.malaika,
            likes = 643,
            caption = "Good Day!!!",
            comments = 56,
            timeAgo = "1 DAY AGO"
        ),
        FeedItem(
            id = 4,
            username = "alyba",
            profileImageRes = R.drawable.alyba,
            postImageRes = R.drawable.dareesha,
            likes = 421,
            caption = " Hey again",
            comments = 34,
            timeAgo = "2 DAYS AGO"
        ),
        FeedItem(
            id = 5,
            username = "malaika",
            profileImageRes = R.drawable.malaika,
            postImageRes = R.drawable.zara,
            likes = 892,
            caption = "Weekend vibes only 🎉",
            comments = 127,
            timeAgo = "3 DAYS AGO"
        ),
        FeedItem(
            id = 6,
            username = "dareesha",
            profileImageRes = R.drawable.dareesha,
            postImageRes = R.drawable.alyba,
            likes = 345,
            caption = "New adventure begins 🚀",
            comments = 67,
            timeAgo = "4 HOURS AGO"
        ),
        FeedItem(
            id = 7,
            username = "zara",
            profileImageRes = R.drawable.zara,
            postImageRes = R.drawable.malaika,
            likes = 678,
            caption = "Art gallery visit 🎨",
            comments = 45,
            timeAgo = "6 HOURS AGO"
        ),
        FeedItem(
            id = 8,
            username = "zoha",
            profileImageRes = R.drawable.zoha,
            postImageRes = R.drawable.dareesha,
            likes = 789,
            caption = "Book reading time 📚",
            comments = 23,
            timeAgo = "1 DAY AGO"
        ),
        FeedItem(
            id = 9,
            username = "alyba",
            profileImageRes = R.drawable.alyba,
            postImageRes = R.drawable.zara,
            likes = 456,
            caption = "Gym session done 💪",
            comments = 89,
            timeAgo = "2 DAYS AGO"
        ),
        FeedItem(
            id = 10,
            username = "malaika",
            profileImageRes = R.drawable.malaika,
            postImageRes = R.drawable.zoha,
            likes = 912,
            caption = "Party night 🥳",
            comments = 156,
            timeAgo = "4 DAYS AGO"
        )
    )

    class FeedViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val profileImage: CircleImageView = view.findViewById(R.id.profile_image)
        val username: TextView = view.findViewById(R.id.username)
        val postImage: ImageView = view.findViewById(R.id.post_image)
        val likeButton: ImageView = view.findViewById(R.id.like_button)
        val saveButton: ImageView = view.findViewById(R.id.save_button)
        val likes: TextView = view.findViewById(R.id.likes)
        val caption: TextView = view.findViewById(R.id.caption)
        val comments: TextView = view.findViewById(R.id.comments)
        val time: TextView = view.findViewById(R.id.time)
        val moreOptions: ImageView = view.findViewById(R.id.more_options)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_feed, parent, false)
        return FeedViewHolder(view)
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        val item = feedItems[position]

        // Load images with Glide - SIMPLIFIED VERSION
        try {
            // Load profile image
            Glide.with(holder.itemView.context)
                .load(item.profileImageRes)
                .into(holder.profileImage)

            // Load post image
            Glide.with(holder.itemView.context)
                .load(item.postImageRes)
                .into(holder.postImage)
        } catch (e: Exception) {
            // Fallback if Glide fails
            holder.profileImage.setImageResource(item.profileImageRes)
            holder.postImage.setImageResource(item.postImageRes)
        }

        // Set text values
        holder.username.text = item.username
        holder.likes.text = "Liked by ${item.likes} people"
        holder.caption.text = item.caption
        holder.comments.text = "View all ${item.comments} comments"
        holder.time.text = item.timeAgo

        // Set button states
        updateLikeButton(holder.likeButton, item.isLiked)
        updateSaveButton(holder.saveButton, item.isSaved)

        // Set click listeners
        holder.likeButton.setOnClickListener {
            val currentItem = feedItems[position]
            currentItem.isLiked = !currentItem.isLiked
            updateLikeButton(holder.likeButton, currentItem.isLiked)

            // Update likes count
            val newLikes = if (currentItem.isLiked) currentItem.likes + 1 else currentItem.likes - 1
            holder.likes.text = "Liked by $newLikes people"

            // Show toast
            val message = if (currentItem.isLiked) "Liked ${currentItem.username}'s post" else "Unliked ${currentItem.username}'s post"
            Toast.makeText(holder.itemView.context, message, Toast.LENGTH_SHORT).show()
        }

        holder.saveButton.setOnClickListener {
            val currentItem = feedItems[position]
            currentItem.isSaved = !currentItem.isSaved
            updateSaveButton(holder.saveButton, currentItem.isSaved)

            val message = if (currentItem.isSaved) "Saved ${currentItem.username}'s post" else "Unsaved ${currentItem.username}'s post"
            Toast.makeText(holder.itemView.context, message, Toast.LENGTH_SHORT).show()
        }

        holder.moreOptions.setOnClickListener {
            Toast.makeText(holder.itemView.context, "More options for ${item.username}'s post", Toast.LENGTH_SHORT).show()
        }

        holder.profileImage.setOnClickListener {
            Toast.makeText(holder.itemView.context, "View ${item.username}'s profile", Toast.LENGTH_SHORT).show()
        }

        holder.postImage.setOnClickListener {
            Toast.makeText(holder.itemView.context, "View ${item.username}'s image", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int = feedItems.size

    private fun updateLikeButton(button: ImageView, isLiked: Boolean) {
        val context = button.context
        if (isLiked) {
            button.setImageResource(android.R.drawable.btn_star_big_on)
            button.setColorFilter(context.getColor(android.R.color.holo_red_light))
        } else {
            button.setImageResource(android.R.drawable.btn_star_big_off)
            button.setColorFilter(context.getColor(android.R.color.white))
        }
    }

    private fun updateSaveButton(button: ImageView, isSaved: Boolean) {
        val context = button.context
        if (isSaved) {
            button.setColorFilter(context.getColor(android.R.color.holo_blue_light))
        } else {
            button.setColorFilter(context.getColor(android.R.color.white))
        }
    }
}