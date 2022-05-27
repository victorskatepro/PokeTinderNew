package com.saico.poketindernew.data


import com.saico.poketindernew.data.model.PokemonListModel
import com.saico.poketindernew.data.model.PokemonModel
import com.saico.poketindernew.data.network.PokemonService
import com.saico.poketindernew.domain.model.Pokemon
import com.saico.poketindernew.domain.model.toDomain
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val pokemonService: PokemonService
) {
    suspend fun getAllPokemonFromApi(): List<Pokemon> {
        val listResponse: PokemonListModel = pokemonService.getPokemons()
        val response: List<PokemonModel> = listResponse.results
        return response.map { it.toDomain() }
    }
}