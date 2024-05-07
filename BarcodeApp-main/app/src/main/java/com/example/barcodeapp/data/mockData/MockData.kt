package com.example.barcodeapp.data.mockData

import com.example.barcodeapp.domain.models.Superhero

class MockData {
    companion object{
        val superheroes = listOf<Superhero>(
            Superhero(1, "Wolverine", "https://example.com/spiderman.jpg"),
            Superhero(2, "Spiderman", "https://example.com/ironman.jpg"),
            Superhero(3, "Ponchadito", "https://example.com/wonderwoman.jpg"),
            Superhero(4, "Taquito", "https://example.com/superman.jpg"),
            Superhero(5, "Batman", "https://example.com/batman.jpg")
        )
    }
}