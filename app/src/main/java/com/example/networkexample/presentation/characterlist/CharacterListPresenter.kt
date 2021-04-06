package com.example.networkexample.presentation.characterlist

import com.example.networkexample.data.NetworkServiceHolder
import com.example.networkexample.domain.mappers.SimpleCharacterMapper
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class CharacterListPresenter constructor(private val view: CharacterListView) {

    private val retrofitService = NetworkServiceHolder.retrofitService!!

    fun onViewCreated() {
        view.setProgressVisible(true)
        retrofitService.getCharacters()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map {
                return@map it.results.map {
                    SimpleCharacterMapper.mapApiToDomain(it)
                }.toList()
            }
            .subscribe(
                {
                    view.setupItemList(it)
                    view.setProgressVisible(false)
                },
                {
                    it.printStackTrace()
                    view.setProgressVisible(false)
                }
            )
    }
}