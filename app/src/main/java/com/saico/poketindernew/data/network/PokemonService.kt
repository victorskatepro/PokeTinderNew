package com.saico.poketindernew.data.network

import com.saico.poketindernew.data.model.PokemonListModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class PokemonService @Inject constructor(private val pokemonApi: PokemonApi) {

    suspend fun getPokemons() : PokemonListModel {
        return withContext(Dispatchers.IO) {
            val res: Response<PokemonListModel> = pokemonApi.getPokemons()
            res.body()!!
        }
    }
}