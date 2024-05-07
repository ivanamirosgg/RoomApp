package com.example.barcodeapp.presentation.states

import com.example.barcodeapp.domain.models.Superhero

data class SuperheroState (
    val superheroes: List<Superhero> = emptyList(),

)