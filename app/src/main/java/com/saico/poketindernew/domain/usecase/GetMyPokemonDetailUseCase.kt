package com.saico.poketindernew.domain.usecase

import com.saico.poketindernew.data.PokemonRepository
import com.saico.poketindernew.data.model.PokemonDetailModel
import javax.inject.Inject

class GetMyPokemonDetailUseCase @Inject constructor(private val repository: PokemonRepository) {

    suspend operator fun invoke(idPokemon: String): PokemonDetailModel {
        return repository.getPokemonDetailFromApi(idPokemon)
    }
}