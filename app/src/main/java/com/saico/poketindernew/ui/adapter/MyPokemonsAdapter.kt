package com.saico.poketindernew.ui.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.saico.poketindernew.R
import com.saico.poketindernew.databinding.ItemPokemonSavedBinding
import com.saico.poketindernew.domain.model.MyPokemon
import com.saico.poketindernew.ui.holder.MyPokemonsHolder
import com.saico.poketindernew.util.formatNumberTo3Digits
import com.saico.poketindernew.util.inflate

class MyPokemonsAdapter(val list: List<MyPokemon>) :
    RecyclerView.Adapter<MyPokemonsHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPokemonsHolder {
        val view = parent.inflate(R.layout.item_pokemon_saved)
        return MyPokemonsHolder(view)
    }

    override fun onBindViewHolder(holder: MyPokemonsHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = list.size

}