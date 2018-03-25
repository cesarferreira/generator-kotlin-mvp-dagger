package cesarferreira.movies.features.details

import cesarferreira.movies.framework.base.BaseMapper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieDetailsApiToMovieDetailsMapper
@Inject constructor() : BaseMapper<MovieDetailsApi, MovieDetails>() {
    override fun transform(source: MovieDetailsApi): MovieDetails {
        return MovieDetails(
                source.id,
                source.title,
                source.year,
                source.cast,
                source.director,
                source.summary,
                source.poster)
    }

}