package com.example.networkexample.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SimpleCharacterEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String
)