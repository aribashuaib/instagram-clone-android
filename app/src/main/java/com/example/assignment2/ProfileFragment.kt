package com.example.assignment2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignment2.databinding.FragmentProfileBinding
import com.bumptech.glide.Glide

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    // Adapters for posts and highlights
    private lateinit var postsAdapter: ProfilePostsAdapter
    private lateinit var highlightsAdapter: ProfileHighlightsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Create a new binding for profile (not using simple fragment)
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupProfileHeader()
        setupHighlights()
        setupPosts()
        setupButtons()
    }

    private fun setupProfileHeader() {
        // Set profile picture
        Glide.with(this)
            .load(R.drawable.mypicture)
            .into(binding.profileImage)

        // Set profile stats - updated as requested
        binding.postsCount.text = "240"
        binding.followersCount.text = "56"
        binding.followingCount.text = "56"

        // Set username and bio - updated as requested
        binding.username.text = "aribashuaib"
        binding.bio.text = "Hey there."
    }

    private fun setupHighlights() {
        binding.highlightsRecycler.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.HORIZONTAL,
            false
        )

        highlightsAdapter = ProfileHighlightsAdapter()
        binding.highlightsRecycler.adapter = highlightsAdapter
        binding.highlightsRecycler.setHasFixedSize(true)
    }

    private fun setupPosts() {
        // 3-column grid layout for posts
        val layoutManager = GridLayoutManager(requireContext(), 3)
        binding.postsRecycler.layoutManager = layoutManager

        postsAdapter = ProfilePostsAdapter()
        binding.postsRecycler.adapter = postsAdapter
    }

    private fun setupButtons() {
        // Edit Profile button
        binding.editProfileBtn.setOnClickListener {
            // Show edit profile dialog or activity
        }

        // Share Profile button
        binding.shareProfileBtn.setOnClickListener {
            // Share profile functionality
        }

        // Bottom navigation items
        binding.gridViewBtn.setOnClickListener {
            switchToGridView()
        }

        binding.reelsViewBtn.setOnClickListener {
            switchToReelsView()
        }

        binding.taggedViewBtn.setOnClickListener {
            switchToTaggedView()
        }
    }

    private fun switchToGridView() {
        binding.gridViewBtn.setColorFilter(requireContext().getColor(android.R.color.white))
        binding.reelsViewBtn.setColorFilter(requireContext().getColor(android.R.color.darker_gray))
        binding.taggedViewBtn.setColorFilter(requireContext().getColor(android.R.color.darker_gray))
        // Show grid posts
    }

    private fun switchToReelsView() {
        binding.gridViewBtn.setColorFilter(requireContext().getColor(android.R.color.darker_gray))
        binding.reelsViewBtn.setColorFilter(requireContext().getColor(android.R.color.white))
        binding.taggedViewBtn.setColorFilter(requireContext().getColor(android.R.color.darker_gray))
        // Show reels
    }

    private fun switchToTaggedView() {
        binding.gridViewBtn.setColorFilter(requireContext().getColor(android.R.color.darker_gray))
        binding.reelsViewBtn.setColorFilter(requireContext().getColor(android.R.color.darker_gray))
        binding.taggedViewBtn.setColorFilter(requireContext().getColor(android.R.color.white))
        // Show tagged posts
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}