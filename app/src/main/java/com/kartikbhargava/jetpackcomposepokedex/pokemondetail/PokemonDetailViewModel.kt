package com.kartikbhargava.jetpackcomposepokedex.pokemondetail

import androidx.lifecycle.ViewModel
import com.kartikbhargava.jetpackcomposepokedex.data.remote.responses.Pokemon
import com.kartikbhargava.jetpackcomposepokedex.repository.PokemonRepository
import com.kartikbhargava.jetpackcomposepokedex.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repository: PokemonRepository
): ViewModel() {

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        return repository.getPokemonInfo(pokemonName)
    }



}