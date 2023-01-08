package com.example.rickmortyv3.ui.create_character

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickmortyv3.data.models.CreatedCharacter
import com.example.rickmortyv3.databinding.ItemCreatedCharacterBinding

class CreatedCharacterAdapter(private val characters: List<CreatedCharacter>) : RecyclerView.Adapter<CreatedCharacterAdapter.ItemViewHolder>() {

    interface ItemListener  {
        fun onItemClicked(index: Int)
    }

//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder
//        ItemViewHolder(ItemCreatedCharacterBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ItemViewHolder(ItemCreatedCharacterBinding.inflate(LayoutInflater.from(parent.context),parent,false))


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val character = characters[position]
        holder.name.text = character.name
        holder.status.text = character.status
        holder.species.text = character.species
        holder.type.text = character.type
        holder.gender.text = character.gender
        Glide.with(holder.itemView.context)
            .load(character.picture)
            .circleCrop()
            .into(holder.image)

    }

    override fun getItemCount() = characters.size

    inner class ItemViewHolder(private val binding: ItemCreatedCharacterBinding)
        : RecyclerView.ViewHolder(binding.root){
        val name = binding.name
        val status = binding.status
        val species = binding.species
        val type = binding.type
        val gender = binding.gender
        val image = binding.image
    }
}