package com.saico.poketindernew.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.saico.poketindernew.R
import com.saico.poketindernew.databinding.ActivityMyPokemonsBinding
import com.saico.poketindernew.domain.model.MyPokemon
import com.saico.poketindernew.ui.adapter.MyPokemonsAdapter

class MyPokemonsActivity : BaseActivity<ActivityMyPokemonsBinding>(ActivityMyPokemonsBinding::inflate) {

    private var listPokemonSaved = mutableListOf<MyPokemon>()

    private val adapter = MyPokemonsAdapter(listPokemonSaved)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_pokemons)
        val pokemonId = intent?.extras?.getString("ID_POKEMON", null)

        if (pokemonId != null) {
            Toast.makeText(this, "PokemonId: $pokemonId", Toast.LENGTH_SHORT).show()
        }

    }

}