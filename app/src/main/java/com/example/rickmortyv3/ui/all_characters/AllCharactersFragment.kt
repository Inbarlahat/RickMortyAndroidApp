package com.example.rickmortyv3.ui.all_characters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickmortyv3.databinding.CharactersFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import com.example.rickmortyv3.R
import com.example.rickmortyv3.utils.*

@AndroidEntryPoint
class AllCharactersFragment : Fragment(), CharactersAdapter.CharacterItemListener {

    private val viewModel : AllCharactersViewModel by viewModels() // initialize view model upon first access

//    private var binding : CharactersFragmentBinding by autoCleared()
    private var _binding: CharactersFragmentBinding? = null

    private val binding get() = _binding!!

    private lateinit var adapter: CharactersAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = CharactersFragmentBinding.inflate(inflater,container,false)

        binding.backHomeBtn.setOnClickListener{
            findNavController().navigate(
                R.id.action_allCharactersFragment_to_homeFragment)}

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = CharactersAdapter(this)
        binding.charactersRv.layoutManager = LinearLayoutManager(requireContext())
        binding.charactersRv.adapter = adapter

        viewModel.characters.observe(viewLifecycleOwner) {
            when (it.status) { // will be called upon a change in the livedata
                is Loading -> binding.progressBar.visibility = View.VISIBLE // if we loading the data -> we will se the progress bar animation

                is Success -> { // if loading was successful
                    binding.progressBar.visibility = View.GONE // vanishes the progress bar
                    adapter.setCharacters(it.status.data!!) // the it status data is forsure not null sunce we cover all error cases before
                }

                is Error -> {
                    binding.progressBar.visibility = View.GONE // vanishes the progress bar
                    Toast.makeText(requireContext(), it.status.message, Toast.LENGTH_LONG).show() // call the error msg from the resource+baseDataSource file
                }
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCharacterClick(characterId: Int) {
       findNavController().navigate(R.id.action_allCharactersFragment_to_singleCharacterFragment,
           bundleOf("id" to characterId))
    }

}