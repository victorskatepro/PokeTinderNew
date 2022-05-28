package com.saico.poketindernew.di

import android.content.Context
import androidx.room.Room
import com.saico.poketindernew.data.database.PokemonDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val POKEMON_DATABASE_NAME = "pokemon_db"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) = Room.databaseBuilder(context, PokemonDB::class.java, POKEMON_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun providePokemonDao(db: PokemonDB) = db.getPokemonDao()
}