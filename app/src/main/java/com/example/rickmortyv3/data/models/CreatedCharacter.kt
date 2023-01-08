package com.example.rickmortyv3.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "created_table")
data class CreatedCharacter(
    @ColumnInfo(name = "name")
    val name:String,

    @ColumnInfo(name = "status")
    val status:String,

    @ColumnInfo(name = "species")
    val species:String,

    @ColumnInfo(name = "type")
    val type:String,

    @ColumnInfo(name = "gender")
    val gender:String?,

    @ColumnInfo(name = "picture")
    val picture:String?)
{

    @PrimaryKey(autoGenerate = true)
    var id : Int = 0
}
