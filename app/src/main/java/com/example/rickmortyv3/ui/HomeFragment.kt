package com.example.rickmortyv3.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.rickmortyv3.R
import com.example.rickmortyv3.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

        private var _binding : FragmentHomeBinding? = null
        private val binding get() = _binding!!

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//    }

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            _binding = FragmentHomeBinding.inflate(inflater,container,false)

            return binding.root
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            binding.charactersButton.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_allCharactersFragment)
            }

            binding.createBtn.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_createNewCharacterFragment)
            }

        }

        override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
        }
    }