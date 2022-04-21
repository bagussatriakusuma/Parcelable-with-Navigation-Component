package com.example.parcelablenavigationcomponent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.parcelablenavigationcomponent.databinding.FragmentScreen1Binding

class Screen1Fragment : Fragment() {

    private var binding: FragmentScreen1Binding? = null
    private val bind get() = binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentScreen1Binding.inflate(inflater,container,false)
        bind.btnFragment1.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_screen1_to_navigation_screen2)
        }
        return bind.root
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}