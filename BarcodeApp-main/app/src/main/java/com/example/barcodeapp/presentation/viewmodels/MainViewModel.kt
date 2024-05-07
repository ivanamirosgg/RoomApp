package com.example.barcodeapp.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.barcodeapp.presentation.states.SuperheroState
import com.example.barcodeapp.domain.use_cases.GetSuperheroes
import com.example.barcodeapp.presentation.events.SuperheroEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(

    private val getSuperheroes: GetSuperheroes
) : ViewModel() {
    private val _state = MutableStateFlow(SuperheroState())
    val state = _state.asStateFlow()


    init {
        viewModelScope.launch {
            try {
                getSuperheroes().collect {
                    _state.value = SuperheroState(superheroes = it)
                }
            } catch (e: Exception) {
                Log.i("Error", e.toString())
            }
        }
    }


}