package com.example.chalenge3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.ViewUtils
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import com.example.chalenge3.databinding.FragmentKeduaBinding
import com.example.chalenge3.databinding.FragmentKetigaBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [fragmentKetiga.newInstance] factory method to
 * create an instance of this fragment.
 */
class fragmentKetiga : Fragment() {
    private var _binding: FragmentKetigaBinding? = null
    private val binding get() = _binding!!

    companion object{
        val nama = "nama"
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentKetigaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val aNama = arguments?.getString(fragmentKedua.extra)
        binding.tvNama.text = "Nama kamu $aNama"

        //data di beri tanda tanya agar bisa kosong
        val dariEmpat = arguments?.getSerializable("Data") as data?
        if (dariEmpat != null){

            //Set Visibility
            binding.tvPekerjaan.visibility = View.VISIBLE
            binding.tvUsia.visibility = View.VISIBLE
            binding.tvAlamat.visibility = View.VISIBLE

            binding.tvNama.text = "Nama kamu = ${dariEmpat.nama}"
            binding.tvAlamat.text = dariEmpat.alamat
            binding.tvPekerjaan.text = dariEmpat.pekerjaan
            if (dariEmpat.usia % 2 == 0){
                val usia = dariEmpat.usia.toString()
                binding.tvUsia.text = "Usia anda $usia, usia anda genap"
            }
            else{
                val usia = dariEmpat.usia.toString()
                binding.tvUsia.text = "Usia anda $usia, usia anda ganjil"
            }
        }

        binding.btnFragmentKeempat.setOnClickListener(){
            val bundle = Bundle()
            bundle.putString(nama,aNama)
            it.findNavController().navigate(R.id.action_fragmentKetiga_to_fragmentKeempat,bundle)
        }
        }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}