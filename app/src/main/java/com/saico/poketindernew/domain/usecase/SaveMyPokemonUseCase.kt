package com.saico.poketindernew.domain.usecase

import com.saico.poketindernew.data.PokemonRepository
import com.saico.poketindernew.data.database.entities.toDatabase
import com.saico.poketindernew.domain.model.MyPokemon
import javax.inject.Inject

class SaveMyPokemonUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository) {

    suspend operator fun invoke(myPokemon: MyPokemon) {
        pokemonRepository.insertMyPokemon(myPokemon.toDatabase())
    }

}