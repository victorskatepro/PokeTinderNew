package com.saico.poketindernew.data


import com.saico.poketindernew.data.database.dao.PokemonDao
import com.saico.poketindernew.data.database.entities.MyPokemonEntity
import com.saico.poketindernew.data.model.PokemonDetailModel
import com.saico.poketindernew.data.model.PokemonListModel
import com.saico.poketindernew.data.model.PokemonModel
import com.saico.poketindernew.data.network.PokemonService
import com.saico.poketindernew.domain.model.MyPokemon
import com.saico.poketindernew.domain.model.Pokemon
import com.saico.poketindernew.domain.model.PokemonDetail
import com.saico.poketindernew.domain.model.toDomain
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val pokemonService: PokemonService,
    private val pokemonDao: PokemonDao
) {
    suspend fun getAllPokemonFromApi(): List<Pokemon> {
        val listResponse: PokemonListModel = pokemonService.getPokemons()
        val response: List<PokemonModel> = listResponse.results
        return response.map { it.toDomain() }
    }

    suspend fun getPokemonDetailFromApi(idPokemon: String): PokemonDetailModel {
        return pokemonService.getPokemonById(idPokemon)
    }

    suspend fun getMyPokemonsFromDatabase(): List<MyPokemon> {
        val response: List<MyPokemonEntity> = pokemonDao.getAllPokemons()
        return response.map { it.toDomain() }
    }

    suspend fun insertMyPokemon(myPokemon: MyPokemonEntity) {
        pokemonDao.insert(myPokemon)
    }
}