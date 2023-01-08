//package com.example.rickmortyv3.ui.favorite_characters
//
//import android.util.Log
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.bumptech.glide.Glide
//import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
//import com.example.rickmortyv3.R
//import com.example.rickmortyv3.data.models.FavoriteCharacter
//import com.example.rickmortyv3.databinding.ItemCreatedCharacterBinding
//
//class FavoriteAdapter : RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>() {
//
//    private lateinit var list : List<FavoriteCharacter>
//
//    private var onItemClickCallback: OnItemClickCallback? = null
//
//    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
//        this.onItemClickCallback = onItemClickCallback
//    }
//
//    fun setFavoriteList(list: List<FavoriteCharacter>){
//        this.list = list
//        notifyDataSetChanged()
//    }
//
//
//    inner class FavoriteViewHolder(private val binding: ItemCreatedCharacterBinding) :
//        RecyclerView.ViewHolder(binding.root) {
//        val name = binding.name
//        val status = binding.status
//        val species = binding.species
//        val type = binding.type
//        val gender = binding.gender
//        val image = binding.image
//
//        fun bind(favoriteCharacter: FavoriteCharacter) {
//            with(binding) {
//                name.text = favoriteCharacter.name
//                status.text = favoriteCharacter.status
//                species.text = favoriteCharacter.species
//                type.text = favoriteCharacter.type
//                gender.text = favoriteCharacter.gender
//                Glide.with(itemView)
//                    .load(favoriteCharacter.picture)
//                    .circleCrop()
//                    .error(R.drawable.ic_error)
//                    .into(image)
//
//                binding.root.setOnClickListener { onItemClickCallback?.onItemClick(favoriteCharacter) }
//            }
//        }
//
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
//        val binding = ItemCreatedCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return FavoriteViewHolder(binding)
//    }
//
//    override fun getItemCount(): Int = list.size
//
//    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
//        holder.bind(list[position])
//    }
//
//    interface OnItemClickCallback {
//        fun onItemClick(favoriteCharacter: FavoriteCharacter)
//    }
//}