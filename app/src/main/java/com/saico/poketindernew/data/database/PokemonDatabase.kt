package com.saico.poketindernew.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.saico.poketindernew.data.database.dao.PokemonDao
import com.saico.poketindernew.data.database.entities.MyPokemonEntity

@Database(entities = [MyPokemonEntity::class], version = 1)
abstract class PokemonDatabase: RoomDatabase() {

    abstract fun getPokemonDao(): PokemonDao
}