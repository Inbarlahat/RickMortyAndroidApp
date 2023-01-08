package com.example.rickmortyv3.data.loca_db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.rickmortyv3.data.loca_db.CharacterDao
import com.example.rickmortyv3.data.models.SingleCharacter

@Database(entities = [SingleCharacter::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun characterDao() : CharacterDao

    companion object {

        @Volatile
        private var instance : AppDatabase?  = null

        fun getDatabase(context: Context) : AppDatabase =
            instance ?: synchronized(this) {
                Room.databaseBuilder(context.applicationContext, AppDatabase::class.java,"characters")
                    .fallbackToDestructiveMigration().build().also {
                        instance = it
                    }
            }
    }
}