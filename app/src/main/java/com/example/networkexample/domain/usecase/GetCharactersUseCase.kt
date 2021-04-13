package com.example.networkexample.domain.usecase

import com.example.networkexample.data.network.NetworkServiceHolder
import com.example.networkexample.domain.mappers.SimpleCharacterMapper
import com.example.networkexample.domain.model.Character
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class GetCharactersUseCase {

    fun execute(): Single<List<Character>> = NetworkServiceHolder.retrofitService!!.getCharacters()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .map {
            return@map it.results.map {
                SimpleCharacterMapper.mapApiToDomain(it)
            }.toList()
        }
}