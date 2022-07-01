package com.saico.poketindernew.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.saico.poketindernew.data.FirebaseRemoteConfigRepository

class SplashViewModel: ViewModel() {

    private var firebaseRemoteConfigRepository = FirebaseRemoteConfigRepository()

    init {
        firebaseRemoteConfigRepository.init()
    }

    fun getIsUnderMaintenance(): MutableLiveData<Boolean> {
        return firebaseRemoteConfigRepository.isUnderMaintenanceLiveData
    }
}