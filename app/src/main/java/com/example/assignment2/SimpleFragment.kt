package com.example.assignment2


import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment

class SimpleFragment(private val title: String) : Fragment(R.layout.fragment_simple) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<TextView>(R.id.titleText).text = title
    }
}
