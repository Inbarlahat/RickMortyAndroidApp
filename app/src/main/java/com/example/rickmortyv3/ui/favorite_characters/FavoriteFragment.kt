//package com.example.rickmortyv3.ui.favorite_characters
//
//import android.os.Bundle
//import android.view.View
//import androidx.fragment.app.Fragment
//import androidx.fragment.app.viewModels
//import androidx.lifecycle.observe
//import androidx.navigation.fragment.findNavController
//import com.example.rickmortyv3.R
//import com.example.rickmortyv3.data.models.FavoriteCharacter
//import com.example.rickmortyv3.data.models.SingleCharacter
//import com.example.rickmortyv3.databinding.*
//import dagger.hilt.android.AndroidEntryPoint
//
//@AndroidEntryPoint
//class FavoriteFragment : Fragment(R.layout.fragment_favorites){
//    private val viewModel by viewModels<FavoriteViewModel>()
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        val binding = FragmentFavoritesBinding.bind(view)
//
//        val adapter = FavoriteAdapter()
//
//        viewModel.favoriteCharacters.observe(viewLifecycleOwner){
//            adapter.setFavoriteList(it)
//            binding.apply {
//                favoriteRecycler.setHasFixedSize(true)
//                favoriteRecycler.adapter = adapter
//            }
//        }
//
//
//        adapter.setOnItemClickCallback(object : FavoriteAdapter.OnItemClickCallback{
//            override fun onItemClick(favoriteCharacter: FavoriteCharacter) {
//                val character = SingleCharacter(
//                    favoriteCharacter.id,
//                    favoriteCharacter.name,
//                    favoriteCharacter.status,
//                    favoriteCharacter.species,
//                    favoriteCharacter.type,
//                    favoriteCharacter.gender,
//                    favoriteCharacter.picture
//                )
//            findNavController().navigate(R.id.action_favoriteFragment_to_singleCharacterFragment)
//            }
//
//        })
//    }
//}