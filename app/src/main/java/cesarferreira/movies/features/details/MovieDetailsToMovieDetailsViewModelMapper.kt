package cesarferreira.movies.features.details

import cesarferreira.movies.framework.base.BaseMapper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieDetailsToMovieDetailsViewModelMapper
@Inject constructor()
    : BaseMapper<MovieDetail, MovieDetailsViewModel>() {
    override fun transform(source: MovieDetail): MovieDetailsViewModel {
        return MovieDetailsViewModel(
                source.title!!,
                source.year!!,
                source.cast!!,
                source.director!!,
                source.summary!!,
                source.poster!!)
    }
}

