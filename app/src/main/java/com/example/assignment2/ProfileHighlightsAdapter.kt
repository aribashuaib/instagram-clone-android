package com.example.assignment2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView

class ProfileHighlightsAdapter : RecyclerView.Adapter<ProfileHighlightsAdapter.HighlightViewHolder>() {

    // Sample highlight data
    private val highlights = listOf(
        Highlight("New", R.drawable.dareesha),
        Highlight("uni-ant", R.drawable.zara),
        Highlight("grites", R.drawable.zoha),
        Highlight("random", R.drawable.alyba),
        Highlight("fun", R.drawable.malaika)
    )

    data class Highlight(val name: String, val imageRes: Int)

    class HighlightViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val highlightImage: CircleImageView = view.findViewById(R.id.highlight_image)
        val highlightName: TextView = view.findViewById(R.id.highlight_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HighlightViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_profile_highlight, parent, false)
        return HighlightViewHolder(view)
    }

    override fun onBindViewHolder(holder: HighlightViewHolder, position: Int) {
        val highlight = highlights[position]

        Glide.with(holder.itemView.context)
            .load(highlight.imageRes)
            .into(holder.highlightImage)

        holder.highlightName.text = highlight.name

        holder.itemView.setOnClickListener {
            // Handle highlight click
        }
    }

    override fun getItemCount() = highlights.size
}