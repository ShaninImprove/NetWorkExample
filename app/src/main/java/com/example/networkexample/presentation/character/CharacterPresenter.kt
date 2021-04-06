package com.example.networkexample.presentation.character

import com.example.networkexample.data.NetworkServiceHolder
import com.example.networkexample.domain.mappers.CharacterInfoMapper
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class CharacterPresenter constructor(private val view: CharacterView) {

    private val retrofitService = NetworkServiceHolder.retrofitService!!

    fun onViewCreated(characterId: Int?) {
        view.setProgressVisible(true)

        characterId?.let {
            retrofitService.getCharacterInfo(it)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map {
                    CharacterInfoMapper.mapApiToDomain(it.result)
                }
                .subscribe(
                    {
                        view.fillData(it.name, it.year, it.gender)
                        view.setProgressVisible(false)
                    },
                    {
                        it.printStackTrace()
                        view.setProgressVisible(false)
                    }
                )
        }
    }
}