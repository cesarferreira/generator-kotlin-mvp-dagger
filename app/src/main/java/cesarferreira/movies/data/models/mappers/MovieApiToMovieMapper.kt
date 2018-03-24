package cesarferreira.movies.data.models.mappers

import cesarferreira.movies.data.models.MovieApi
import cesarferreira.movies.domain.entities.Movie
import cesarferreira.movies.presentation.framework.base.BaseMapper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieApiToMovieMapper
@Inject constructor()
    : BaseMapper<MovieApi, Movie>() {

    override fun transform(source: MovieApi): Movie {
        return Movie(source.id, source.title, source.poster)
    }
}