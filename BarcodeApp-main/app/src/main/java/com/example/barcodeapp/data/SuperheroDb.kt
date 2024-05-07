package com.example.barcodeapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.barcodeapp.data.dao.SuperheroDao
import com.example.barcodeapp.domain.models.Superhero

@Database(entities = [Superhero::class], version = 1)
abstract class SuperheroDb : RoomDatabase() {
    abstract fun superheroDao(): SuperheroDao
}