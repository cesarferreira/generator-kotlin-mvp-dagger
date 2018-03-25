package cesarferreira.movies.features.listing

import cesarferreira.movies.framework.base.BaseMapper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieApiToMovieMapper
@Inject constructor()
    : BaseMapper<MovieApi, Movie>() {

    override fun transform(source: MovieApi): Movie {
        return Movie(source.id, source.poster)
    }
}