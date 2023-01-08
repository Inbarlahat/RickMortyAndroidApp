package com.example.rickmortyv3.data.repository

import android.app.Application
import com.example.rickmortyv3.data.loca_db.CreatedCharactersDao
import com.example.rickmortyv3.data.loca_db.CreatedCharactersDatabase
import com.example.rickmortyv3.data.models.CreatedCharacter


class CreatedCharacterRepository(application: Application) {

    private var createdCharactersDao: CreatedCharactersDao?

    init {
        val db = CreatedCharactersDatabase.getDatabase(application)
        createdCharactersDao = db.createdCharactersDao()
    }

    fun getCreatedCharacters() = createdCharactersDao?.getCreatedCharacters()

    suspend fun addCreatedCharacter(createdCharacter: CreatedCharacter) {
            createdCharactersDao?.addCreatedCharacter(createdCharacter)
    }

}
