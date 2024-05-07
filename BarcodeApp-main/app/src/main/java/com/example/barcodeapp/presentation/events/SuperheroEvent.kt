package com.example.barcodeapp.presentation.events

sealed class SuperheroEvent {
    data class OnScan(val name: String) : SuperheroEvent()
    object OnDelete : SuperheroEvent()
}