package cesarferreira.movies.features.listing

import cesarferreira.movies.framework.base.BaseMapper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieToMovieViewModelMapper
@Inject constructor()
    : BaseMapper<Movie, MovieViewModel>() {

    override fun transform(source: Movie): MovieViewModel {
        return MovieViewModel(source.id!!, source.poster!!)
    }
}