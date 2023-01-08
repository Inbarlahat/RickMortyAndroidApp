package com.example.rickmortyv3.ui.create_character

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.ItemTouchHelper.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rickmortyv3.databinding.CreatedCharactersFragmentBinding
import com.example.rickmortyv3.R
import com.example.rickmortyv3.data.models.CreatedCharacter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreatedCharactersFragment : Fragment() {

    private val viewModel : CreatedCharacterViewModel by viewModels() // initialize view model upon first access

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = CreatedCharactersFragmentBinding.inflate(inflater,container,false)

//        _binding = CreatedCharactersFragmentBinding.inflate(inflater,container,false)

        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_createdCharactersFragment_to_createNewCharacterFragment)
        }

        binding.backHomeBtn.setOnClickListener{
            findNavController().navigate(
                R.id.action_createdCharactersFragment_to_homeFragment)}


        viewModel.getCreatedCharacters()?.observe(viewLifecycleOwner) {
            binding.recycler.adapter = CreatedCharacterAdapter(it)
        }


        with(binding.recycler) {
            layoutManager = LinearLayoutManager(context)}

        ItemTouchHelper(object  : ItemTouchHelper.Callback() {

            override fun getMovementFlags(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder
            ) = makeFlag(ACTION_STATE_SWIPE, LEFT or RIGHT)
            //or makeFlag(ACTION_STATE_DRAG, UP or DOWN or LEFT or RIGHT)

            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                TODO("Not yet implemented")
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
//                viewModel.deleteCreatedCharacters(direction)
                viewHolder.itemView.visibility = View.INVISIBLE
//                ItemsManger.remove(viewHolder.adapterPosition)
                binding.recycler.adapter!!.notifyItemRemoved(viewHolder.adapterPosition)

            }
        }).attachToRecyclerView(binding.recycler)

        return binding.root
    }
}