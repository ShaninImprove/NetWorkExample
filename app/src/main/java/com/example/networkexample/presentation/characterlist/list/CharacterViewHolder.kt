package com.example.networkexample.presentation.characterlist.list

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.networkexample.R
import com.example.networkexample.domain.model.Character

class CharacterViewHolder(rootView: View) : RecyclerView.ViewHolder(rootView) {

    private lateinit var textViewId: TextView
    private lateinit var textViewName: TextView

    fun bind(character: Character) {
        textViewId = itemView.findViewById(R.id.text_view_id_value)
        textViewName = itemView.findViewById(R.id.text_view_name_value)

        textViewId.text = character.id.toString()
        textViewName.text = character.name
    }
}