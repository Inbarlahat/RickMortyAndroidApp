package com.example.rickmortyv3.ui.create_character

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickmortyv3.data.models.CreatedCharacter
import com.example.rickmortyv3.data.repository.CreatedCharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CreatedCharacterViewModel(application: Application) : AndroidViewModel(application) {

    private var repository = CreatedCharacterRepository(application)

    fun getCreatedCharacters() = repository.getCreatedCharacters()


//    fun deleteCreatedCharacters(id : Int)
//    {
//        viewModelScope.launch {
//            repository.deleteCreatedCharacter(id)
//        }
//    }

    fun addCreatedCharacter(createdCharacter: CreatedCharacter) {
        viewModelScope.launch {
            repository.addCreatedCharacter(createdCharacter)
        }
    }
}