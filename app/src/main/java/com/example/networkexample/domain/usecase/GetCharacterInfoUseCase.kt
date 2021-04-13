package com.example.networkexample.domain.usecase

import com.example.networkexample.data.network.NetworkServiceHolder
import com.example.networkexample.domain.mappers.CharacterInfoMapper
import com.example.networkexample.domain.model.CharacterInfo
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class GetCharacterInfoUseCase {

    fun execute(id: Int): Single<CharacterInfo> = NetworkServiceHolder.retrofitService!!
        .getCharacterInfo(id)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .map {
            CharacterInfoMapper.mapApiToDomain(it.result)
        }
}