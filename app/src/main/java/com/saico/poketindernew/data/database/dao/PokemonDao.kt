package com.saico.poketindernew.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.saico.poketindernew.data.database.entities.PokemonEntity

@Dao
interface PokemonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(pokemonEntity: PokemonEntity)

    @Query("SELECT * FROM pokemon")
    suspend fun getAllPokemons(): List<PokemonEntity>
}