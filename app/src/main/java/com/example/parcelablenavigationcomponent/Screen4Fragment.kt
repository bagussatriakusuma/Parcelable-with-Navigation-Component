package com.example.parcelablenavigationcomponent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.parcelablenavigationcomponent.databinding.FragmentScreen4Binding

class Screen4Fragment : Fragment() {
    private var binding: FragmentScreen4Binding? = null
    private val bind get() = binding!!

    private val args by navArgs<Screen4FragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentScreen4Binding.inflate(inflater,container,false)

        bind.btnFragment4.setOnClickListener {
            //val bundle = Bundle()
            if (bind.etFragment4usia.text.isNullOrEmpty()) {
                Toast.makeText(requireContext(), "Kolom usia masih kosong", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }else if(bind.etFragment4alamat.text.isNullOrEmpty()){
                Toast.makeText(requireContext(), "Kolom alamat masih kosong", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }else if(bind.etFragment4pekerjaan.text.isNullOrEmpty()) {
                Toast.makeText(requireContext(), "Kolom alamat masih kosong", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }else {
                val usia = bind.etFragment4usia.text.toString().toInt()
                val alamat = bind.etFragment4alamat.text.toString()
                val pekerjaan = bind.etFragment4pekerjaan.text.toString()
                val nama = arguments?.getString("nama")
                val biodata = Biodata(nama,usia,alamat,pekerjaan)

                val goto = Screen4FragmentDirections.actionNavigationScreen4ToNavigationScreen3(biodata)
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