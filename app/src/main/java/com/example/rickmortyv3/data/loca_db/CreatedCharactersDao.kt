package com.example.rickmortyv3.data.loca_db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.rickmortyv3.data.models.CreatedCharacter
import com.example.rickmortyv3.data.models.SingleCharacter

@Dao
interface CreatedCharactersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCreatedCharacter(createdCharacter: CreatedCharacter)

//    @Delete
//    suspend fun deleteCreatedCharacter(id : Int)

    @Update
    fun updateCreatedCharacter(createdCharacter: CreatedCharacter)

    @Query("SELECT * from created_table ORDER BY name ASC")
    fun getCreatedCharacters() : LiveData<List<CreatedCharacter>>

    @Query("SELECT * from created_table WHERE name LIKE :title")
    fun getCreatedCharacter(title : String) : CreatedCharacter
}