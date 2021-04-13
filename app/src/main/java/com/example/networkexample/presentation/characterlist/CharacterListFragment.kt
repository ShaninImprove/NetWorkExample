package com.example.networkexample.presentation.characterlist

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
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
import com.google.android.material.snackbar.Snackbar

class CharacterListFragment : Fragment(R.layout.fragment_character_list), CharacterListView {

    private lateinit var recyclerView: RecyclerView
    private lateinit var progress: LinearProgressIndicator
    private lateinit var toolbar: Toolbar

    private lateinit var rootView: View

    private val adapter = CharacterListAdapter() {
        presenter.onCharacterClicked(it)
    }

    private var presenter: CharacterListPresenter = CharacterListPresenter(this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rootView = view

        recyclerView = view.findViewById(R.id.recycler_view_character)
        progress = view.findViewById(R.id.progress)
        toolbar = view.findViewById(R.id.toolbar)
        presenter.onViewCreated()

        toolbar.inflateMenu(R.menu.list_menu)
        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.db_menu_item ->  {
                    presenter.getCharactersFromDb()
                    return@setOnMenuItemClickListener true
                }
            }
            false
        }
        initRecycler()
    }

    fun initRecycler() {
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val decorator = DividerItemDecoration(
            requireContext(),
            LinearLayoutManager.VERTICAL
        )
        recyclerView.addItemDecoration(decorator)
        recyclerView.adapter = adapter
    }

    override fun setupItemList(list: List<Character>) {
        adapter.setItemList(list)
    }

    override fun setProgressVisible(isVisible: Boolean) {
        progress.isVisible = isVisible
    }

    override fun openCharacterScreen(characterId: Int) {
        (requireActivity() as MainActivity).openCharacterScreen(characterId)
    }

    override fun showSnackBar(text: String) {
        Snackbar.make(rootView, text, Snackbar.LENGTH_SHORT)
    }
}