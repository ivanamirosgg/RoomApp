package com.example.barcodeapp.domain.models
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "superhero")
data class Superhero(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val image: String
)