package com.example.assignment2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignment2.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup Stories RecyclerView (horizontal scrolling)
        setupStoriesRecyclerView()

        // Setup Feed RecyclerView (vertical scrolling)
        setupFeedRecyclerView()
    }

    private fun setupStoriesRecyclerView() {
        // Horizontal layout manager for stories
        val storiesLayoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.HORIZONTAL,
            false
        )
        binding.storyRecycler.layoutManager = storiesLayoutManager
        binding.storyRecycler.adapter = StoryAdapter()

        // Optimize performance
        binding.storyRecycler.setHasFixedSize(true)

        // Enable horizontal scrolling for stories
        binding.storyRecycler.isNestedScrollingEnabled = true
    }

    private fun setupFeedRecyclerView() {
        // Vertical layout manager for feed
        val feedLayoutManager = LinearLayoutManager(requireContext())
        binding.feedRecycler.layoutManager = feedLayoutManager
        binding.feedRecycler.adapter = FeedAdapter()

        // IMPORTANT: Disable nested scrolling to allow NestedScrollView to handle scrolling
        binding.feedRecycler.isNestedScrollingEnabled = false

        // Don't set fixed size (allows variable height items)
        binding.feedRecycler.setHasFixedSize(false)

        // Optional: Add item decoration for spacing
        // binding.feedRecycler.addItemDecoration(ItemDecoration(16))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}