package com.example.chalenge3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import com.example.chalenge3.databinding.FragmentKeduaBinding
import com.example.chalenge3.databinding.FragmentKeempatBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [fragmentKeempat.newInstance] factory method to
 * create an instance of this fragment.
 */
class fragmentKeempat : Fragment() {
    private var _binding: FragmentKeempatBinding? = null
    private val binding get() = _binding!!

    companion object{

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentKeempatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnFragmentKetiga.setOnClickListener(){
            if (binding.etUsia.text.isNullOrEmpty()||binding.etAlamat.text.isNullOrEmpty()||binding.etPekerjaan.text.isNullOrEmpty()){
                Toast.makeText(requireContext(), "Kolom masih kosong", Toast.LENGTH_SHORT).show()
            }
            else{
                val nama = arguments?.getString(fragmentKetiga.nama)
                var usia = binding.etUsia.text.toString().toInt()
                var alamat = binding.etAlamat.text.toString()
                var Pekerjaan = binding.etPekerjaan.text.toString()
//                val mBundle = Bundle()
//                mBundle.putInt("usia",usia)
//                mBundle.putString("alamat",alamat)
//                mBundle.putString("pekerjaan",Pekerjaan)
                //nama diberi tanda tanya menghidari data kosong
                val Data = nama?.let { it1 -> data(it1,usia,alamat,Pekerjaan) }
                val bundle = bundleOf("Data" to Data)
                it.findNavController().navigate(R.id.action_fragmentKeempat_to_fragmentKetiga,bundle)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}