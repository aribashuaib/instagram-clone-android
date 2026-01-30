package com.example.assignment2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ProfilePostsAdapter : RecyclerView.Adapter<ProfilePostsAdapter.PostViewHolder>() {

    // Sample posts data (using existing images)
    private val posts = listOf(
        R.drawable.dareesha, R.drawable.zara, R.drawable.zoha,
        R.drawable.alyba, R.drawable.malaika, R.drawable.dareesha,
        R.drawable.zara, R.drawable.zoha, R.drawable.alyba,
        R.drawable.malaika, R.drawable.dareesha, R.drawable.zara
    )

    class PostViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val postImage = view.findViewById<android.widget.ImageView>(R.id.post_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_profile_post, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val imageRes = posts[position]

        Glide.with(holder.itemView.context)
            .load(imageRes)
            .into(holder.postImage)

        holder.itemView.setOnClickListener {
            // Open post detail
        }
    }

    override fun getItemCount() = posts.size
}