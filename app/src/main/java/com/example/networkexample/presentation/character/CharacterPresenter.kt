package com.example.networkexample.presentation.character

import com.example.networkexample.data.network.NetworkServiceHolder
import com.example.networkexample.domain.mappers.CharacterInfoMapper
import com.example.networkexample.domain.usecase.GetCharacterInfoUseCase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class CharacterPresenter constructor(private val view: CharacterView) {

    private val getCharacterInfoUseCase = GetCharacterInfoUseCase()

    fun onViewCreated(characterId: Int?) {
        view.setProgressVisible(true)

        characterId?.let {
            getCharacterInfoUseCase.execute(characterId)
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