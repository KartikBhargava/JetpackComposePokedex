package com.kartikbhargava.jetpackcomposepokedex.repository

import com.kartikbhargava.jetpackcomposepokedex.data.remote.PokeApi
import com.kartikbhargava.jetpackcomposepokedex.data.remote.responses.Pokemon
import com.kartikbhargava.jetpackcomposepokedex.data.remote.responses.PokemonList
import com.kartikbhargava.jetpackcomposepokedex.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import java.lang.Exception
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val pokeApi: PokeApi
) {

    suspend fun getPokemonList(limit: Int, offset: Int) : Resource<PokemonList> {
        val response = try {
            pokeApi.getPokemonList(limit, offset)
        } catch(e : Exception) {
            return Resource.Error(message = "Phatt gaya bhai")
        }
        return Resource.Success(data = response)
    }

    suspend fun getPokemonInfo(pokemonName: String) : Resource<Pokemon> {
        val response = try {
            pokeApi.getPokemonInfo(pokemonName)
        } catch(e : Exception) {
            return Resource.Error(message = "Phatt gaya bhai")
        }
        return Resource.Success(data = response)
    }

}