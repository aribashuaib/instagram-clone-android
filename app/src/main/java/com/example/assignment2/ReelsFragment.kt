package com.example.assignment2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignment2.databinding.FragmentReelsBinding
import com.bumptech.glide.Glide

class ReelsFragment : Fragment() {

    private var _binding: FragmentReelsBinding? = null
    private val binding get() = _binding!!
    private lateinit var reelsAdapter: ReelsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // We need to create a new binding for reels
        // First, create fragment_reels.xml (I'll provide the code below)
        _binding = FragmentReelsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupReelsRecyclerView()
    }

    private fun setupReelsRecyclerView() {
        binding.reelsRecycler.layoutManager = LinearLayoutManager(requireContext())
        reelsAdapter = ReelsAdapter()
        binding.reelsRecycler.adapter = reelsAdapter
        binding.reelsRecycler.setHasFixedSize(true)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}