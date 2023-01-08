package com.example.rickmortyv3.data.remote_db

import com.example.rickmortyv3.data.models.AllCharacters
import com.example.rickmortyv3.data.models.SingleCharacter
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterService {

    @GET("character")
    suspend fun getAllCharacters() : Response<AllCharacters>

    @GET("character/{id}")
    suspend fun getCharacter(@Path("id") id : Int) : Response<SingleCharacter>

//    @GET("character/{name}")
//    suspend fun getCharactersByName(@Path("name") name : String): Response<AllCharacters>

//    @GET("character")
//    suspend fun getCharactersbyStatusAndGender(@Path("status") status : String,
//                                               @Path("gender") gender : String,
//                                               @Path("page") page : Int): Response<SingleCharacter>
//
//    @GET("character")
//    suspend fun getCharactersByStatus(@Query("status") status : String, @Query("page") page : Int): Response<SingleCharacter>
//
//    @GET("character/{gender}")
//    suspend fun getCharactersByGender(@Query("gender") gender : String, @Query("page") page : Int): Response<SingleCharacter>

}