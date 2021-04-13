package com.example.networkexample.presentation.characterlist

import com.example.networkexample.domain.model.Character
import com.example.networkexample.domain.usecase.ClearCharactersDbUseCase
import com.example.networkexample.domain.usecase.GetCharactersFromDbUseCase
import com.example.networkexample.domain.usecase.GetCharactersUseCase
import com.example.networkexample.domain.usecase.InsertCharactersToDbUseCase

class CharacterListPresenter constructor(private val view: CharacterListView) {

    private val getCharactersUseCase = GetCharactersUseCase()
    private val clearCharacterTableUseCase = ClearCharactersDbUseCase()
    private val insertCharactersToDbUseCase = InsertCharactersToDbUseCase()
    private val getCharactersFromDbUseCase = GetCharactersFromDbUseCase()

    fun onCharacterClicked(characterId: Int) {
        view.openCharacterScreen(characterId)
    }

    fun onViewCreated() {
        view.setProgressVisible(true)
        getCharactersUseCase.execute()
            .subscribe(
                {
                    rewriteCharactersTable(it)
                    view.setupItemList(it)
                    view.setProgressVisible(false)
                },
                {
                    it.printStackTrace()
                    view.setProgressVisible(false)
                }
            )
    }

    private fun rewriteCharactersTable(characters: List<Character>) {
        clearCharacterTableUseCase.execute()
            .andThen(insertCharactersToDbUseCase.execute(characters))
            .subscribe(
                {
                    view.showSnackBar("Db table filled")
                },
                {
                    it.printStackTrace()
                }
            )
    }

    fun getCharactersFromDb() {
        getCharactersFromDbUseCase.execute()
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