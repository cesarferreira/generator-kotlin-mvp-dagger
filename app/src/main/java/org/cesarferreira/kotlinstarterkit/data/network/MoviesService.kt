package org.cesarferreira.kotlinstarterkit.data.network

import io.reactivex.Observable
import org.cesarferreira.kotlinstarterkit.data.entities.ResponseEntity
import retrofit2.http.GET

interface MoviesService {

    @GET("api/movies")
    fun getMovies(): Observable<ResponseEntity>
}