package com.example.barcodeapp.domain.repositories

import com.example.barcodeapp.domain.models.Superhero
import kotlinx.coroutines.flow.Flow

interface SuperheroRepository {
    suspend fun getAllSuperheroes(): Flow<List<Superhero>>


}