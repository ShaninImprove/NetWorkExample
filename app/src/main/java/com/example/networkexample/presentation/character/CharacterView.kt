package com.example.networkexample.presentation.character

interface CharacterView {

    fun setProgressVisible(isVisible: Boolean)

    fun fillData(name: String, birthYear: String, gender: String)
}