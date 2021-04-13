package com.example.networkexample.presentation.characterlist

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.networkexample.R
import com.example.networkexample.domain.model.Character
import com.example.networkexample.presentation.MainActivity
import com.example.networkexample.presentation.characterlist.list.CharacterListAdapter
import com.google.android.material.progressindicator.LinearProgressIndicator

class CharacterListFragment : Fragment(R.layout.fragment_character_list), CharacterListView {

    private lateinit var recyclerView: RecyclerView
    private lateinit var progress: LinearProgressIndicator

    private var presenter: CharacterListPresenter = CharacterListPresenter(this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recycler_view_character)
        progress = view.findViewById(R.id.progress)
        presenter.onViewCreated()
    }

    override fun setupItemList(list: List<Character>) {
        val adapter = CharacterListAdapter(list) {
            presenter.onCharacterClicked(it)
        }
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val decorator = DividerItemDecoration(
            requireContext(),
            LinearLayoutManager.VERTICAL
        )
        recyclerView.addItemDecoration(decorator)
        recyclerView.adapter = adapter
    }

    override fun setProgressVisible(isVisible: Boolean) {
        progress.isVisible = isVisible
    }

    override fun openCharacterScreen(characterId: Int) {
        (requireActivity() as MainActivity).openCharacterScreen(characterId)
    }
}