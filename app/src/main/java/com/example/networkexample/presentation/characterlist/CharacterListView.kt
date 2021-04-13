package com.example.networkexample.presentation.characterlist

import com.example.networkexample.domain.model.Character

interface CharacterListView {

    fun setupItemList(list: List<Character>)

    fun setProgressVisible(isVisible: Boolean)

    fun openCharacterScreen(characterId: Int)
}