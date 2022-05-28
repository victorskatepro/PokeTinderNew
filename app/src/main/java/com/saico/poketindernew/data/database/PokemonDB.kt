package com.saico.poketindernew.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.saico.poketindernew.data.database.dao.PokemonDao
import com.saico.poketindernew.data.database.entities.PokemonEntity

@Database(entities = [PokemonEntity::class], exportSchema = false, version = 1)
abstract class PokemonDB: RoomDatabase() {

    abstract fun getPokemonDao(): PokemonDao
}