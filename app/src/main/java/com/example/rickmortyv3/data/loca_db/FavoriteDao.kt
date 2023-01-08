//package com.example.rickmortyv3.data.loca_db
//
//import androidx.lifecycle.LiveData
//import androidx.room.*
//import com.example.rickmortyv3.data.models.CreatedCharacter
//import com.example.rickmortyv3.data.models.FavoriteCharacter
//import com.example.rickmortyv3.data.models.SingleCharacter
//
//@Dao
//interface FavoriteDao {
//
//    @Insert
//    suspend fun addToFavorite(favoriteCharacter: FavoriteCharacter)
//
//    @Query("SELECT * FROM favorite_table")
//    fun getFavoriteCharacter(): LiveData<List<FavoriteCharacter>>
//
//    @Query("SELECT count(*) FROM favorite_table WHERE favorite_table.id = :id")
//    suspend fun checkFavorite(id: Int): Int
//
//    @Query("DELETE FROM favorite_table WHERE favorite_table.id = :id" )
//    suspend fun removeFromFavorite(id: Int) : Int
//
//}