package com.example.networkexample.domain.usecase

import com.example.networkexample.data.database.DataBaseHolder
import com.example.networkexample.domain.mappers.SimpleCharacterMapper
import com.example.networkexample.domain.model.Character
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class GetCharactersFromDbUseCase {

    fun execute(): Single<List<Character>> = DataBaseHolder
        .database!!
        .characterListDao()
        .getAll()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .map {
            it.map { SimpleCharacterMapper.mapDbToDomain(it) }.toList()
        }
}