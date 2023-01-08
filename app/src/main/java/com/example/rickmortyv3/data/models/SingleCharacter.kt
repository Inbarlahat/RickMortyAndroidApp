package com.example.rickmortyv3.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "characters")
data class SingleCharacter(
    @PrimaryKey
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,

    @SerializedName("image")
    val picture: String
) {
}

object CharacterManger {

    val characters : MutableList<SingleCharacter> = mutableListOf()

    fun add(character : SingleCharacter) {
        characters.add(character)
    }

    fun remove(index : Int){
        characters.removeAt(index)
    }
}