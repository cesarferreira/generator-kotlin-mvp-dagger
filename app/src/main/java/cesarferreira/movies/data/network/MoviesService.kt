package cesarferreira.movies.data.network

import cesarferreira.movies.features.details.MovieDetailsApi
import cesarferreira.movies.features.listing.MovieListResponseApi
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface MoviesService {

    @GET("api/movies")
    fun getMovies(): Single<MovieListResponseApi>

    @GET("api/movies/{id}")
    fun getMovieDetails(@Path("id") id: String): Single<MovieDetailsApi>
}