package com.example.networkexample.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.networkexample.R
import com.example.networkexample.presentation.character.CharacterFragment
import com.example.networkexample.presentation.characterlist.CharacterListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        openListScreen()
    }

    private fun openListScreen() {
        supportFragmentManager.beginTransaction().replace(
            R.id.fragment_container,
            CharacterListFragment()
        ).commit()
    }

    fun openCharacterScreen(characterId: Int) {
        supportFragmentManager.beginTransaction().replace(
            R.id.fragment_container,
            CharacterFragment.newInstance(characterId))
            .addToBackStack(null)
            .commit()
    }
}