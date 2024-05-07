package com.example.barcodeapp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.barcodeapp.domain.models.Superhero
import kotlinx.coroutines.flow.Flow

@Dao
interface SuperheroDao {
    @Query("SELECT * FROM superhero")
    fun getAllProducts(): Flow<List<Superhero>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(superheroes: List<Superhero>)
}
