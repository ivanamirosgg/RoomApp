package com.example.barcodeapp.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.barcodeapp.R
import com.example.barcodeapp.domain.adapters.SuperheroAdapter
import com.example.barcodeapp.domain.models.Superhero
import com.example.barcodeapp.presentation.events.SuperheroEvent
import com.example.barcodeapp.presentation.viewmodels.MainViewModel
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanOptions
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var button: Button
    private lateinit var superheroesRecyclerView: RecyclerView
    private val superheroes = mutableListOf<Superhero>()
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.btn_scan)


        observeState()

    }

    private fun observeState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                mainViewModel.state.collect {
                    Log.i("Superheroes: ", superheroes.toString())

                }
            }
        }
    }

    private fun observeUiEvent() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                mainViewModel.state.collect {
                    Log.i("Products", it.superheroes.toString())
                }
            }
        }
    }


}