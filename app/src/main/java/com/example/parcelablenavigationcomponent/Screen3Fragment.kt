package com.example.parcelablenavigationcomponent

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.parcelablenavigationcomponent.databinding.FragmentScreen3Binding

class Screen3Fragment : Fragment() {
    private var binding: FragmentScreen3Binding? = null
    private val bind get() = binding!!
    private val args by navArgs<Screen3FragmentArgs>()

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentScreen3Binding.inflate(inflater,container,false)

        val nama = args.currentBiodata.nama
        val usia = args.currentBiodata.usia
        if(usia == null){
            val usiaNull = ""
            bind.tvFragment3.text = "Nama Anda : ${args.currentBiodata.nama} " +
                    "${usiaNull} " +
                    "${args.currentBiodata.alamat} " +
                    "${args.currentBiodata.pekerjaan}"
        }else{
            val evenOdd = if (usia % 2 == 0) "genap" else "ganjil"
            bind.tvFragment3.text = "Nama Anda : ${args.currentBiodata.nama} " +
                    "\nUsia Anda : ${usia}, bernilai ${evenOdd} " +
                    "\nAlamat Anda : ${args.currentBiodata.alamat} " +
                    "\nPekerjaan Anda : ${args.currentBiodata.pekerjaan}"
        }

        bind.btnFragment3.setOnClickListener {
            val bundle = Bundle()
            bundle.putString(Constant.nama, nama)
            findNavController().navigate(R.id.action_navigation_screen3_to_navigation_screen4,bundle)
        }

        return bind.root
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}