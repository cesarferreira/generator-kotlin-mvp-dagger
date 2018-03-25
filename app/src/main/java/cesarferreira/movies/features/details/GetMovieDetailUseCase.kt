package cesarferreira.movies.features.details

import cesarferreira.movies.data.network.MoviesService
import cesarferreira.movies.framework.base.BaseUseCase
import io.reactivex.Single
import javax.inject.Inject

class GetMovieDetailUseCase
@Inject constructor(private val service: MoviesService,
                    private val moviewDetailsApiToMovieDetailsMapper: MovieDetailsApiToMovieDetailsMapper)
    : BaseUseCase<Single<MovieDetail>, GetMovieDetailUseCase.Params>() {

    override fun buildUseCase(params: Params): Single<MovieDetail> {
        return service.getMovieDetails(params.id)
                .map({ moviewDetailsApiToMovieDetailsMapper.transform(it) })
    }

    data class Params(val id: String)
}