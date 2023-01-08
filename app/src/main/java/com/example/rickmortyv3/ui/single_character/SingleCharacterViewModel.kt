package com.example.rickmortyv3.ui.single_character

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import dagger.hilt.android.lifecycle.HiltViewModel
//import com.example.rickmortyv3.data.repository.FavoriteCharacterRepository
//import com.example.rickmortyv3.data.models.FavoriteCharacter
import com.example.rickmortyv3.data.repository.CharacterRepository
import com.example.rickmortyv3.utils.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import com.example.rickmortyv3.data.models.SingleCharacter
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SingleCharacterViewModel @Inject constructor(
    private val characterRepository: CharacterRepository
): ViewModel() {

    private val _id =  MutableLiveData<Int>()
    // inner field so _, i want the character will be a transformation of this livedata

    private val _character = _id.switchMap {
        // each time i will change the value, whoever observe the characters will get notified
        // change in one property will change another property

        // whenever the _id will change, i will execute this lambda, and the returned value will be saved in _character

        characterRepository.getCharacter(it)
    }

    val character : LiveData<Resource<SingleCharacter>> = _character // this is what i return to the user, its like giving him a copy of the instance

    fun setId(id : Int) {
        _id.value = id
    }

//    fun addToFavorite(character: SingleCharacter){
//        CoroutineScope(Dispatchers.IO).launch {
//            favoriteCharacterRepository.addToFavorite(
//                FavoriteCharacter(
//                    character.id,
//                    character.name,
//                    character.gender,
//                    character.species,
//                    character.status,
//                    character.picture
//                )
//            )
//        }
//        }
//
//    suspend fun checkCharacter(id: Int) = favoriteCharacterRepository.checkCharacter(id)
//
//    fun removeFromFavorite(id: Int){
//        CoroutineScope(Dispatchers.IO).launch {
//            favoriteCharacterRepository.removeFromFavorite(id)
//        }
//    }

}