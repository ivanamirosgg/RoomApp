package com.example.barcodeapp.domain.use_cases

import com.example.barcodeapp.domain.models.Superhero
import com.example.barcodeapp.domain.repositories.SuperheroRepository
import kotlinx.coroutines.flow.Flow

class GetSuperheroes(private val repository: SuperheroRepository) {
    suspend operator fun invoke(): Flow<List<Superhero>> {
        return repository.getAllSuperheroes()
    }
}