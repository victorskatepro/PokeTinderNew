package com.saico.poketindernew.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemon")
data class PokemonEntity(
   @PrimaryKey(autoGenerate = true)
   val id: Int = 0,
   val idPokemon: String,
   val name: String,
   val image: String,
   val isLegendary: Boolean = false,
   val position: Int = -1
)