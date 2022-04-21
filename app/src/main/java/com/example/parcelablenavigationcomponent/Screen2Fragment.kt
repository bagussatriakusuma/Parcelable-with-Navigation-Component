package com.example.parcelablenavigationcomponent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.parcelablenavigationcomponent.databinding.FragmentScreen2Binding

class Screen2Fragment : Fragment() {
    private var binding: FragmentScreen2Binding? = null
    private val bind get() = binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentScreen2Binding.inflate(inflater,container,false)

        bind.btnFragment2.setOnClickListener {
            if (bind.etFragment2.text.isNullOrEmpty()) {
                Toast.makeText(requireContext(), "Kolom nama masih kosong", Toast.LENGTH_SHORT).show()
            } else {
                val nama = bind.etFragment2.text.toString()
                val biodata = Biodata(nama,null,"","")

                val goto = Screen2FragmentDirections.actionNavigationScreen2ToNavigationScreen3(biodata)
                findNavController().navigate(goto)
            }
        }
        return bind.root
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}