package com.saico.poketindernew.domain.usecase

import com.saico.poketindernew.data.PokemonRepository
import com.saico.poketindernew.domain.model.MyPokemon
import javax.inject.Inject

class GetMyPokemonsUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository) {

    suspend operator fun invoke(): List<MyPokemon> {
        return pokemonRepository.getMyPokemonsFromDatabase()
    }

}