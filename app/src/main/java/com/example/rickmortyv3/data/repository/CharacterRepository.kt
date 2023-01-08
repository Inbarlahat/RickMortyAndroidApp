package com.example.rickmortyv3.data.repository

import com.example.rickmortyv3.data.loca_db.CharacterDao
import com.example.rickmortyv3.data.models.AllCharacters
import com.example.rickmortyv3.data.remote_db.CharacterRemoteDataSource
import com.example.rickmortyv3.utils.performFetchingAndSaving
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharacterRepository @Inject constructor(
    private val remoteDataSource : CharacterRemoteDataSource,
    private val localDataSource : CharacterDao
){

    fun getCharacters() = performFetchingAndSaving(
        {localDataSource.getAllCharacters()},
        {remoteDataSource.getCharacters()},
        {localDataSource.insertCharacters(it.results)}
    )

    fun getCharacter(id : Int) = performFetchingAndSaving(
        {localDataSource.getCharacter(id)},
        {remoteDataSource.getCharacter(id)},
        {localDataSource.insertCharacter(it)}
    )
//
//    suspend fun getCharactersByName(name: String): AllCharacters{
//        return localDataSource.getCharactersByName(name)
//    }
//
//    suspend fun getCharactersbyStatusAndGender(status : String, gender: String, page:Int): AllCharacters{
//        return localDataSource.getCharactersbyStatusAndGender(status, gender, page)
//    }
//
//    suspend fun getCharactersByStatus(status : String, page:Int): AllCharacters{
//        return localDataSource.getCharactersByStatus(status, page)
//    }
//
//    suspend fun getCharactersByGender(gender : String, page:Int): AllCharacters{
//        return localDataSource.getCharactersByGender(gender, page)
//    }
}