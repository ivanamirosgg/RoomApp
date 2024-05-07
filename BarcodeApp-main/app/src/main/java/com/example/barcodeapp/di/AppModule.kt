package com.example.barcodepp.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.barcodeapp.data.SuperheroDb
import com.example.barcodeapp.data.dao.SuperheroDao
import com.example.barcodeapp.data.mockData.MockData
import com.example.barcodeapp.data.repositories.SuperheroRepositoryImpl
import com.example.barcodeapp.domain.models.Superhero
import com.example.barcodeapp.domain.repositories.SuperheroRepository
import com.example.barcodeapp.domain.use_cases.GetSuperheroes
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Volatile
    private var INSTANCE: SuperheroDb? = null


    @Provides
    @Singleton
    fun provideSuperheroDb(
        @ApplicationContext context: Context
    ): SuperheroDb {
        return INSTANCE ?: synchronized(this) {
            val instance = INSTANCE
            if (instance != null) {
                return instance
            } else {
                val callback = object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        CoroutineScope(Dispatchers.IO).launch {
                            val db = INSTANCE ?: return@launch
                            val superheroDao = db.superheroDao()
                            superheroDao.insertAll(MockData.superheroes)
                        }
                    }


                }
                return Room.databaseBuilder(
                    context.applicationContext,
                    SuperheroDb::class.java, "room_DB"
                )
                    .addCallback(callback).build().also {
                        INSTANCE = it
                    }
            }
        }
    }

        @Provides
        @Singleton
        fun provideSuperheroRepository(db: SuperheroDb): SuperheroRepository {
            return SuperheroRepositoryImpl(db.superheroDao())
        }

        @Provides
        @Singleton
        fun provideGetSuperheroes(superheroRepository: SuperheroRepository): GetSuperheroes {
            return GetSuperheroes(superheroRepository)
        }

}