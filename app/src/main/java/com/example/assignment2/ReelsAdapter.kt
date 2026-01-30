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

data class ReelItem(
    val id: Int,
    val username: String,
    val profileImageRes: Int = R.drawable.mypicture,
    val reelImageRes: Int = R.drawable.reel,  // Always use reel image
    val caption: String,
    val views: String,
    val likes: String,
    val comments: String,
    val shares: String,
    val duration: String,
    var isLiked: Boolean = false,
    var isSaved: Boolean = false
)

class ReelsAdapter : RecyclerView.Adapter<ReelsAdapter.ReelViewHolder>() {

    private val reelItems = listOf(
        ReelItem(
            id = 1,
            username = "amina",
            profileImageRes = R.drawable.mypicture,
            reelImageRes = R.drawable.reel,  // Your reel image
            caption = "send it to him 😊",
            views = "1.2M views",
            likes = "1.2K",
            comments = "245",
            shares = "56",
            duration = "0:15"
        ),
        ReelItem(
            id = 2,
            username = "aribashuaib",
            profileImageRes = R.drawable.mypicture,
            reelImageRes = R.drawable.reel,  // Your reel image
            caption = "Hey World",
            views = "856K views",
            likes = "45K",
            comments = "1.2K",
            shares = "234",
            duration = "0:22"
        ),
        ReelItem(
            id = 3,
            username = "dareesha",
            profileImageRes = R.drawable.dareesha,
            reelImageRes = R.drawable.reel,  // Your reel image
            caption = "Follow for more content!",
            views = "543K views",
            likes = "32K",
            comments = "876",
            shares = "123",
            duration = "0:18"
        ),
        ReelItem(
            id = 4,
            username = "zara",
            profileImageRes = R.drawable.zara,
            reelImageRes = R.drawable.reel,  // Your reel image
            caption = "Daily vibes ✨",
            views = "2.1M views",
            likes = "128K",
            comments = "3.4K",
            shares = "567",
            duration = "0:30"
        ),
        ReelItem(
            id = 5,
            username = "zoha",
            profileImageRes = R.drawable.zoha,
            reelImageRes = R.drawable.reel,  // Your reel image
            caption = "New reel alert!",
            views = "987K views",
            likes = "67K",
            comments = "2.1K",
            shares = "345",
            duration = "0:25"
        ),
        ReelItem(
            id = 6,
            username = "alyba",
            profileImageRes = R.drawable.alyba,
            reelImageRes = R.drawable.reel,  // Your reel image
            caption = "Behind the scenes",
            views = "765K views",
            likes = "54K",
            comments = "1.8K",
            shares = "289",
            duration = "0:20"
        ),
        ReelItem(
            id = 7,
            username = "malaika",
            profileImageRes = R.drawable.malaika,
            reelImageRes = R.drawable.reel,  // Your reel image
            caption = "Weekend special 🎉",
            views = "1.5M views",
            likes = "89K",
            comments = "2.5K",
            shares = "432",
            duration = "0:28"
        )
    )

    class ReelViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val reelImage: ImageView = view.findViewById(R.id.reel_image)
        val profileImage: CircleImageView = view.findViewById(R.id.reel_profile)
        val username: TextView = view.findViewById(R.id.reel_username)
        val views: TextView = view.findViewById(R.id.reel_views)
        val caption: TextView = view.findViewById(R.id.reel_caption)
        val likeButton: ImageView = view.findViewById(R.id.reel_like)
        val likesCount: TextView = view.findViewById(R.id.reel_likes_count)
        val commentsCount: TextView = view.findViewById(R.id.reel_comments_count)
        val sharesCount: TextView = view.findViewById(R.id.reel_shares_count)
        val saveButton: ImageView = view.findViewById(R.id.reel_save)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReelViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_reel, parent, false)
        return ReelViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReelViewHolder, position: Int) {
        val item = reelItems[position]

        // Load images - ALWAYS use R.drawable.reel for reel image
        Glide.with(holder.itemView.context)
            .load(R.drawable.reel)  // Always your reel image
            .into(holder.reelImage)

        Glide.with(holder.itemView.context)
            .load(item.profileImageRes)
            .into(holder.profileImage)

        // Set text values
        holder.username.text = item.username
        holder.views.text = item.views
        holder.caption.text = item.caption
        holder.likesCount.text = item.likes
        holder.commentsCount.text = item.comments
        holder.sharesCount.text = item.shares

        // Set button states
        updateLikeButton(holder.likeButton, item.isLiked)
        updateSaveButton(holder.saveButton, item.isSaved)

        // Click listeners
        holder.likeButton.setOnClickListener {
            val currentItem = reelItems[position]
            currentItem.isLiked = !currentItem.isLiked
            updateLikeButton(holder.likeButton, currentItem.isLiked)

            val message = if (currentItem.isLiked) "Liked ${currentItem.username}'s reel" else "Unliked ${currentItem.username}'s reel"
            Toast.makeText(holder.itemView.context, message, Toast.LENGTH_SHORT).show()
        }

        holder.saveButton.setOnClickListener {
            val currentItem = reelItems[position]
            currentItem.isSaved = !currentItem.isSaved
            updateSaveButton(holder.saveButton, currentItem.isSaved)

            val message = if (currentItem.isSaved) "Saved ${currentItem.username}'s reel" else "Unsaved ${currentItem.username}'s reel"
            Toast.makeText(holder.itemView.context, message, Toast.LENGTH_SHORT).show()
        }

        holder.profileImage.setOnClickListener {
            Toast.makeText(holder.itemView.context, "View ${item.username}'s profile", Toast.LENGTH_SHORT).show()
        }

        holder.reelImage.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Playing ${item.username}'s reel", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount() = reelItems.size

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