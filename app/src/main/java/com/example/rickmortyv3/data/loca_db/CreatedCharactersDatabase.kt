package com.example.rickmortyv3.data.loca_db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.rickmortyv3.data.models.CreatedCharacter

@Database(entities = [CreatedCharacter::class],version = 1,exportSchema = false)
abstract class CreatedCharactersDatabase : RoomDatabase() {

    abstract fun createdCharactersDao() : CreatedCharactersDao

    companion object {
        private var instance: CreatedCharactersDatabase? = null

        fun getDatabase(context:Context) = instance ?: synchronized(this) {
            Room.databaseBuilder(context.applicationContext, CreatedCharactersDatabase::class.java,"created_database")
                .build().also { instance = it }
        }

    }
}