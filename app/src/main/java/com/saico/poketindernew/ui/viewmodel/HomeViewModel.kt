package com.saico.poketindernew.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.remoteconfig.ktx.get
import com.saico.poketindernew.data.FirebaseRemoteConfigRepository
import com.saico.poketindernew.data.PokemonRepository
import com.saico.poketindernew.data.database.entities.toDatabase
import com.saico.poketindernew.di.NetworkModule
import com.saico.poketindernew.domain.model.MyPokemon
import com.saico.poketindernew.domain.model.Pokemon
import com.saico.poketindernew.domain.usecase.GetPokemonsUseCase
import com.saico.poketindernew.domain.usecase.SaveMyPokemonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel  @Inject constructor(
    private val getPokemonsUseCase: GetPokemonsUseCase,
    private val saveMyPokemonUseCase: SaveMyPokemonUseCase
): ViewModel() {
    val pokemonList = MutableLiveData<List<Pokemon>>()
    val isLoading = MutableLiveData<Boolean>()

    private var firebaseRemoteConfigRepository = FirebaseRemoteConfigRepository()
    init {
        firebaseRemoteConfigRepository.init()
    }

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getPokemonsUseCase()
            pokemonList.postValue(result)
            isLoading.postValue(false)
        }
    }

    fun savePokemonUseCase(myPokemon: MyPokemon) {
        viewModelScope.launch {
            isLoading.postValue(true)
            saveMyPokemonUseCase.invoke(myPokemon)
            isLoading.postValue(false)
        }
    }

    fun getUrlPokemon(): MutableLiveData<String> {
        return firebaseRemoteConfigRepository.getUrlPokemonLiveData
    }


}