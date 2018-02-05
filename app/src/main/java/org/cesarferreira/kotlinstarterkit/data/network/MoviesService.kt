package org.cesarferreira.kotlinstarterkit.data.network

import io.reactivex.Single
import org.cesarferreira.kotlinstarterkit.data.models.MovieDetailsApi
import org.cesarferreira.kotlinstarterkit.data.models.ResponseApi
import retrofit2.http.GET
import retrofit2.http.Path

interface MoviesService {

    @GET("api/movies")
    fun getMovies(): Single<ResponseApi>

    @GET("api/movies/{id}")
    fun getMovieDetails(@Path("id") id: String): Single<MovieDetailsApi>
}