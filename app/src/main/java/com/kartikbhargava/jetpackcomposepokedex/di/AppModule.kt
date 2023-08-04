package com.kartikbhargava.jetpackcomposepokedex.di

import com.kartikbhargava.jetpackcomposepokedex.data.remote.ApiEndPoints.BASE_URL
import com.kartikbhargava.jetpackcomposepokedex.data.remote.PokeApi
import com.kartikbhargava.jetpackcomposepokedex.repository.PokemonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providePokemonRepository(
        pokeApi: PokeApi
    ) = PokemonRepository(pokeApi)

    @Singleton
    @Provides
    fun providePokeApi(): PokeApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(PokeApi::class.java)
    }

}