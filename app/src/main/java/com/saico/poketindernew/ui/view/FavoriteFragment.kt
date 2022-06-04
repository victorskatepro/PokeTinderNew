package com.saico.poketindernew.ui.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.saico.poketindernew.R
import com.saico.poketindernew.databinding.FragmentFavoriteBinding
import com.saico.poketindernew.domain.model.MyPokemon
import com.saico.poketindernew.ui.adapter.MyPokemonsAdapter
import com.saico.poketindernew.ui.viewmodel.FavoriteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : BaseFragment<FragmentFavoriteBinding>(FragmentFavoriteBinding::inflate) {

    private var listMyPokemon = mutableListOf<MyPokemon>()

    private val adapter by lazy { MyPokemonsAdapter(listMyPokemon) }

    private val viewModel: FavoriteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        viewModel.onCreate()

        binding.rvPokemons.adapter = adapter

        viewModel.myPokemonList.observe(this) {
            listMyPokemon.addAll(it)
            adapter.notifyDataSetChanged()
        }
    }
}