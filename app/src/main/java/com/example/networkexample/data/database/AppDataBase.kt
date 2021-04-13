package com.example.networkexample.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.networkexample.data.database.dao.CharacterListDao
import com.example.networkexample.data.database.entities.SimpleCharacterEntity

@Database(entities = [SimpleCharacterEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun characterListDao(): CharacterListDao
}