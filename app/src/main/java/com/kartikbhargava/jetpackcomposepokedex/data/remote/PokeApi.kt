package com.kartikbhargava.jetpackcomposepokedex.data.remote

import com.kartikbhargava.jetpackcomposepokedex.data.remote.ApiEndPoints.POKEMON_INFO
import com.kartikbhargava.jetpackcomposepokedex.data.remote.ApiEndPoints.POKEMON_LIST
import com.kartikbhargava.jetpackcomposepokedex.data.remote.responses.Pokemon
import com.kartikbhargava.jetpackcomposepokedex.data.remote.responses.PokemonList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApi {

    @GET(POKEMON_LIST)
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ) : PokemonList

    @GET(POKEMON_INFO)
    suspend fun getPokemonInfo(
        @Path("pokemonName") pokemonName: String
    ) : Pokemon
}