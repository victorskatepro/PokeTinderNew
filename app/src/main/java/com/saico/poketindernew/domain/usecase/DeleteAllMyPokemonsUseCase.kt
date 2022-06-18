package com.saico.poketindernew.domain.usecase

import com.saico.poketindernew.data.PokemonRepository
import javax.inject.Inject

class DeleteAllMyPokemonsUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository) {

    suspend operator fun invoke() {
        pokemonRepository.deleteAllMyPokemon()
    }
}