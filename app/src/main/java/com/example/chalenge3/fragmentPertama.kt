package com.example.chalenge3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.chalenge3.databinding.FragmentPertamaBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class fragmentPertama : Fragment() {
    private var _binding: FragmentPertamaBinding? = null
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPertamaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         binding.btnFragmentKedua.setOnClickListener(){
             it.findNavController().navigate(R.id.action_fragmentPertama_to_fragmentKedua)
         }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
