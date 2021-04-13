package com.example.networkexample.presentation.characterlist.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.networkexample.R
import com.example.networkexample.domain.model.Character

class CharacterListAdapter constructor(
    private val onClick: (characterId: Int) -> Unit
) : RecyclerView.Adapter<CharacterViewHolder>() {

    private var itemList = listOf<Character>()

    fun setItemList(itemList: List<Character>) {
        this.itemList = itemList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
        return CharacterViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int = itemList.size
}