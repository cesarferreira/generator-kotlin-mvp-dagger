package cesarferreira.movies.data.network

import io.reactivex.Single
import cesarferreira.movies.data.models.MovieDetailsApi
import cesarferreira.movies.data.models.ResponseApi
import retrofit2.http.GET
import retrofit2.http.Path

interface MoviesService {

    @GET("api/movies")
    fun getMovies(): Single<ResponseApi>

    @GET("api/movies/{id}")
    fun getMovieDetails(@Path("id") id: String): Single<MovieDetailsApi>
}