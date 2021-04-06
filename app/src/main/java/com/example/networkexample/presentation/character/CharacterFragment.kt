package com.example.networkexample.presentation.character

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.networkexample.R
import com.google.android.material.progressindicator.LinearProgressIndicator

class CharacterFragment : Fragment(R.layout.fragment_character_screen), CharacterView {

    private lateinit var progress: LinearProgressIndicator

    private lateinit var nameTextView: TextView
    private lateinit var birthYearTextView: TextView
    private lateinit var genderTextView: TextView

    private val presenter = CharacterPresenter(this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        progress = view.findViewById(R.id.progress)
        nameTextView = view.findViewById(R.id.text_view_name_value)
        birthYearTextView = view.findViewById(R.id.text_view_birth_year_value)
        genderTextView = view.findViewById(R.id.text_view_gender_value)

        presenter.onViewCreated(arguments?.getInt(CHARACTER_ID_KEY))
    }

    override fun setProgressVisible(isVisible: Boolean) {
        progress.isVisible = isVisible
    }

    override fun fillData(name: String, birthYear: String, gender: String) {
        nameTextView.text = name
        birthYearTextView.text = birthYear
        genderTextView.text = gender
    }

    companion object {
        private const val CHARACTER_ID_KEY = "CharacterFragment.CHARACTER_ID_KEY"

        fun newInstance(characterId: Int): CharacterFragment {
            val args = Bundle()
            args.putInt(CHARACTER_ID_KEY, characterId)

            val fragment = CharacterFragment()
            fragment.arguments = args
            return fragment
        }
    }
}