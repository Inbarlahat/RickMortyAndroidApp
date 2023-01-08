package com.example.rickmortyv3.ui.all_characters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickmortyv3.data.models.SingleCharacter
import com.example.rickmortyv3.databinding.ItemCharacterBinding

class CharactersAdapter(private val listener : CharacterItemListener) :
    RecyclerView.Adapter<CharactersAdapter.CharacterViewHolder>() {

    private val characters = ArrayList<SingleCharacter>()

    class CharacterViewHolder(private val itemBinding: ItemCharacterBinding,
                              private val listener: CharacterItemListener
    )
        : RecyclerView.ViewHolder(itemBinding.root),
        View.OnClickListener {

        private lateinit var character: SingleCharacter

        init {
            itemBinding.root.setOnClickListener(this)
        }

        fun bind(item: SingleCharacter) {
            this.character = item
            itemBinding.name.text = item.name
            itemBinding.speciesAndStatus.text = "${item.species} - ${item.status}"
            Glide.with(itemBinding.root)
                .load(item.picture)
                .into(itemBinding.image)
        }

        override fun onClick(v: View?) {
            listener.onCharacterClick(character.id)
        }
    }

    fun setCharacters(characters: List<SingleCharacter>) {
        this.characters.clear()
        this.characters.addAll(characters)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding = ItemCharacterBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CharacterViewHolder(binding,listener)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) =
        holder.bind(characters[position])


    override fun getItemCount() = characters.size

    interface CharacterItemListener {
        fun onCharacterClick(characterId : Int)
    }


}