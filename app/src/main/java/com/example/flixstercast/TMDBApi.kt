package com.example.flixstercast

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://api.themoviedb.org/3/"
private const val API_KEY = "a07e22bc18f5cb106bfe4cc1f83ad8ed" // Replace with your actual TMDB API key

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: TMDBApi by lazy {
        retrofit.create(TMDBApi::class.java)
    }
}

interface TMDBApi {

    @GET("person/popular")
    suspend fun getPopularPeople(@Query("api_key") apiKey: String = API_KEY): PopularPeopleResponse
}
