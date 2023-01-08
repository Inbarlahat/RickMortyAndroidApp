package com.example.rickmortyv3.ui.single_character

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.rickmortyv3.R
import dagger.hilt.android.AndroidEntryPoint
import com.example.rickmortyv3.utils.Loading
import com.example.rickmortyv3.utils.Success
import com.example.rickmortyv3.utils.Error
import com.example.rickmortyv3.utils.autoCleared
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import com.example.rickmortyv3.data.models.SingleCharacter
import com.example.rickmortyv3.ui.single_character.SingleCharacterViewModel
import com.example.rickmortyv3.databinding.CharacterDetailFragmentBinding

@AndroidEntryPoint
class SingleCharacterFragment : Fragment() {

    private val viewModel : SingleCharacterViewModel by viewModels()

    private var binding : CharacterDetailFragmentBinding by autoCleared()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CharacterDetailFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.character.observe(viewLifecycleOwner) {
            when(it.status) {
                is Success -> {
                    binding.progressBar.visibility = View.GONE
                    updateCharacter(it.status.data!!) // update relevent details card
                    binding.characterCl.visibility = View.VISIBLE // show details card
                }
                is Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.characterCl.visibility = View.GONE // dont show details card while loading
                }
                is Error -> {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(requireContext(),it.status.message,Toast.LENGTH_LONG).show()
                }
            }
        }

        binding.backButton.setOnClickListener{
            findNavController().navigate(
                R.id.action_singleCharacterFragment_to_allCharactersFragment)}

        arguments?.getInt("id")?.let { // it should propegate the character field observation
            viewModel.setId(it)
        }
    }

    private fun updateCharacter(character : SingleCharacter) {
        binding.name.text = character.name
        binding.type.text = character.type
        binding.gender.text = character.gender
        binding.species.text = character.species
        binding.status.text = character.status
        Glide.with(requireContext())
            .load(character.picture)
            .circleCrop()
            .into(binding.image)

//        var _isChecked = false
//        CoroutineScope(Dispatchers.IO).launch{
//            val count = viewModel.checkCharacter(character.id)
//            withContext(Dispatchers.Main){
//                if (count > 0){
//                    binding.toggleFavorite.isChecked = true
//                    _isChecked = true
//                }else{
//                    binding.toggleFavorite.isChecked = false
//                    _isChecked = false
//                }
//            }

        }
//
//        binding.toggleFavorite.setOnClickListener {
//            _isChecked = !_isChecked
//            if (_isChecked){
//                viewModel.addToFavorite(character)
//                Toast.makeText(requireContext(),"${character.name} was ADDED to favorites",Toast.LENGTH_LONG).show()
//            } else{
//                viewModel.removeFromFavorite(character.id)
//                Toast.makeText(requireContext(),"${character.name} was REMOVED from favorites",Toast.LENGTH_LONG).show()
//            }
//            binding.toggleFavorite.isChecked = _isChecked
//        }
//    }
}