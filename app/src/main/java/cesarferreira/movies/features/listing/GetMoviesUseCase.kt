package cesarferreira.movies.features.listing

import cesarferreira.movies.data.network.MoviesService
import cesarferreira.movies.framework.base.BaseUseCase
import io.reactivex.Single
import javax.inject.Inject

class GetMoviesUseCase
@Inject constructor(private val service: MoviesService,
                    private val movieApiToMovieMapper: MovieApiToMovieMapper)
    : BaseUseCase<Single<List<Movie>>, BaseUseCase.None>() {

    override fun buildUseCase(params: None): Single<List<Movie>> {
        return service.getMovies()
                .map({ movieApiToMovieMapper.transform(it.data) })
    }

}