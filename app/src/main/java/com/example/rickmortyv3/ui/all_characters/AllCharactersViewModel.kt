package com.example.rickmortyv3.ui.all_characters

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import com.example.rickmortyv3.data.repository.CharacterRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AllCharactersViewModel @Inject constructor(
    characterRepository: CharacterRepository
) : ViewModel() {

    val characters  = characterRepository.getCharacters()

    var filterValue = MutableLiveData<Array<Int>>()
    var isFilter = MutableLiveData<Boolean>()

    init {
        filterValue.value = arrayOf(0, 0)
        isFilter.value = false
    }

//    fun getByName(name: String, characterRepository: CharacterRepository){
//        viewModelScope.launch{
//            val characters = characterRepository.getCharactersByName(name)
//            isFilter.value = true
//        }
//    }
//
//    fun getByStatusAndGender(status : String, gender: String, page:Int, characterRepository: CharacterRepository){
//        viewModelScope.launch{
//            val characters = characterRepository.getCharactersbyStatusAndGender(status, gender, page)
//            isFilter.value = true
//        }
//    }
//
//    fun getByStatus(status : String, page:Int, characterRepository: CharacterRepository){
//        viewModelScope.launch{
//            val characters = characterRepository.getCharactersByStatus(status, page)
//            isFilter.value = true
//        }
//    }
//
//    fun getByGender(gender: String, page:Int, characterRepository: CharacterRepository){
//        viewModelScope.launch{
//            val characters = characterRepository.getCharactersByGender(gender, page)
//            isFilter.value = true
//        }
//    }

}