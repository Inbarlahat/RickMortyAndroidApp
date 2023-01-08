//package com.example.rickmortyv3.data.loca_db
//
//import android.content.Context
//import androidx.room.Database
//import androidx.room.Room
//import androidx.room.RoomDatabase
//import com.example.rickmortyv3.data.models.CreatedCharacter
//import com.example.rickmortyv3.data.models.FavoriteCharacter
//
//@Database(entities = [FavoriteCharacter::class],version = 1,exportSchema = false)
//abstract class FavoriteDatabase : RoomDatabase() {
//
//    abstract fun favoriteDao() : FavoriteDao
//
//    companion object {
//
//        private var instance: FavoriteDatabase? = null
//
//        //in more Kotlin way
//        fun getDatabase(context:Context) = instance ?: synchronized(this) {
//            Room.databaseBuilder(context.applicationContext, FavoriteDatabase::class.java,"favorite_database")
//                .build().also { instance = it }
//        }
//
//    }
//}