package com.example.networkexample.presentation.characterlist

import com.example.networkexample.domain.usecase.GetCharactersUseCase

class CharacterListPresenter constructor(private val view: CharacterListView) {

    private val getCharactersUseCase = GetCharactersUseCase()

    fun onCharacterClicked(characterId: Int) {
        view.openCharacterScreen(characterId)
    }

    fun onViewCreated() {
        view.setProgressVisible(true)
        getCharactersUseCase.execute()
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