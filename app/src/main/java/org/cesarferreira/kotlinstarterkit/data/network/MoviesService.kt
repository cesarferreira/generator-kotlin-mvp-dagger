package org.cesarferreira.kotlinstarterkit.data.network

import io.reactivex.Single
import org.cesarferreira.kotlinstarterkit.data.entities.MovieDetailsEntity
import org.cesarferreira.kotlinstarterkit.data.entities.ResponseEntity
import retrofit2.http.GET
import retrofit2.http.Path

interface MoviesService {

    @GET("api/movies")
    fun getMovies(): Single<ResponseEntity>

    @GET("api/movies/{id}")
    fun getMovieDetails(@Path("id") id: String): Single<MovieDetailsEntity>
}