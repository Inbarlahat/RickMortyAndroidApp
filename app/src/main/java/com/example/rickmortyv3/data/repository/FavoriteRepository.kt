//package com.example.rickmortyv3.data.repository
//
//import android.app.Application
//import com.example.rickmortyv3.data.loca_db.CreatedCharactersDao
//import com.example.rickmortyv3.data.loca_db.CreatedCharactersDatabase
//import com.example.rickmortyv3.data.loca_db.FavoriteDao
//import com.example.rickmortyv3.data.models.CreatedCharacter
//import com.example.rickmortyv3.data.models.FavoriteCharacter
//import javax.inject.Inject
//import javax.inject.Singleton
//
//@Singleton
//class FavoriteRepository @Inject constructor(
//    private val favoriteDao: FavoriteDao
//){
//    suspend fun addToFavorite(favoriteCharacter: FavoriteCharacter) = favoriteDao.addToFavorite(favoriteCharacter)
//    fun getFavorites() = favoriteDao.getFavoriteCharacter()
//    suspend fun checkFavorite(id: Int) = favoriteDao.checkFavorite(id)
//    suspend fun removeFromFavorite(id: Int) {
//        favoriteDao.removeFromFavorite(id)
//    }
//}
