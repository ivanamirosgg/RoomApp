package com.example.barcodeapp.data.repositories

import com.example.barcodeapp.data.dao.SuperheroDao
import com.example.barcodeapp.domain.models.Superhero

import com.example.barcodeapp.domain.repositories.SuperheroRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class SuperheroRepositoryImpl @Inject constructor (
    private val superheroDao: SuperheroDao
) : SuperheroRepository {

    override suspend fun getAllSuperheroes(): Flow<List<Superhero>> {
        return superheroDao.getAllProducts()
    }
}