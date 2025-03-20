package com.packt.chaptereight.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.packt.chaptereight.data.Cat
import com.packt.chaptereight.data.NetworkResult
import com.packt.chaptereight.data.PetsRepository
import com.packt.chaptereight.data.asResult
import com.packt.chaptereight.views.PetsUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.serialization.InternalSerializationApi

class PetsViewModel(
    private val petsRepository: PetsRepository
): ViewModel() {
    @OptIn(InternalSerializationApi::class)
    val petsUIState = MutableStateFlow(PetsUIState())
    @OptIn(InternalSerializationApi::class)
    private val _favoritePets = MutableStateFlow<List<Cat>>(emptyList())
    @OptIn(InternalSerializationApi::class)
    val favoritePets: StateFlow<List<Cat>> get() = _favoritePets

    init {
        getPets()
    }

    @OptIn(InternalSerializationApi::class)
     fun getPets() {
        petsUIState.value = PetsUIState(isLoading = true)
        viewModelScope.launch {
            Log.d("maxLog", "viewModelScope")
            petsRepository.getPets().asResult().collect { result ->
                Log.d("maxLog", "getPets")
                when (result ) {
                    is NetworkResult.Success -> {
                        Log.d("maxLog", "getPets Success")
                        petsUIState.update {
                            it.copy(isLoading = false, pets = result.data)
                        }
                    }
                    is NetworkResult.Error -> {
                        petsUIState.update {
                            it.copy(isLoading = false, error = result.error)
                        }
                    }
                }
            }
        }
    }

    @OptIn(InternalSerializationApi::class)
    fun updatePet(cat: Cat) {
        viewModelScope.launch {
            petsRepository.updatePet(cat)
        }
    }

    @OptIn(InternalSerializationApi::class)
    fun getFavoritePets() {
        viewModelScope.launch {
            petsRepository.getFavoritePets().collect {
                _favoritePets.value = it
            }
        }
    }
}