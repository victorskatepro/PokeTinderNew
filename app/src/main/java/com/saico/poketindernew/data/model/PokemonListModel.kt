package com.saico.poketindernew.data.model

import com.google.gson.annotations.SerializedName
import com.saico.poketindernew.util.getIdPokemonFromUrl
import java.io.Serializable

data class PokemonListModel(

    @SerializedName("count") val count: Int,

    @SerializedName("results") val results: List<PokemonModel>

)