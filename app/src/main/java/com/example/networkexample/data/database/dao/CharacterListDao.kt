package com.example.networkexample.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.networkexample.data.database.entities.SimpleCharacterEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
interface CharacterListDao {

    @Query("SELECT * FROM SimpleCharacterEntity")
    fun getAll(): Single<List<SimpleCharacterEntity>>

    @Query("DELETE FROM SimpleCharacterEntity")
    fun clearAll(): Completable

    @Insert
    fun insertAll(characters: List<SimpleCharacterEntity>): Completable
}