package com.example.networkexample.domain.usecase

import com.example.networkexample.data.database.DataBaseHolder
import com.example.networkexample.data.database.entities.SimpleCharacterEntity
import com.example.networkexample.domain.mappers.SimpleCharacterMapper
import com.example.networkexample.domain.model.Character
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.schedulers.Schedulers

class InsertCharactersToDbUseCase {

    fun execute(characters: List<Character>) = DataBaseHolder
        .database!!
        .characterListDao()
        .insertAll(characters.map { SimpleCharacterMapper.mapDomainToDb(it) }.toList())
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}