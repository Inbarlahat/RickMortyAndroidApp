package com.example.rickmortyv3.data.loca_db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.rickmortyv3.data.models.AllCharacters
import com.example.rickmortyv3.data.models.SingleCharacter
import com.example.rickmortyv3.di.AppModule
import com.example.rickmortyv3.data.remote_db.CharacterService
import retrofit2.http.GET

@Dao
interface CharacterDao {

    @Query("SELECT * FROM characters ORDER BY name ASC")
    fun getAllCharacters() : LiveData<List<SingleCharacter>>

    @Query("SELECT * FROM characters WHERE id = :id")
    fun getCharacter(id : Int) : LiveData<SingleCharacter>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacter(character: SingleCharacter)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacters(characters: List<SingleCharacter>)

//    @GET("character")
//    suspend fun getCharactersByName(@Path("name") name : String): AllCharacters

////    @GET("character")
//    suspend fun getCharactersbyStatusAndGender(@Path("status") status : String,
//                                               @Path("gender") gender : String,
//                                               @Path("page") page : Int): AllCharacters
//
////    @GET("character")
//    suspend fun getCharactersByStatus(@Path("status") status : String, @Path("page") page : Int): AllCharacters
//
////    @GET("character")
//    suspend fun getCharactersByGender(@Path("gender") gender : String, @Path("page") page : Int): AllCharacters


}