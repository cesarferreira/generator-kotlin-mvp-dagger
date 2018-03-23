package org.cesarferreira.kotlinstarterkit.data.models.mappers

import org.cesarferreira.kotlinstarterkit.data.models.MovieApi
import org.cesarferreira.kotlinstarterkit.domain.entities.Movie
import org.cesarferreira.kotlinstarterkit.presentation.framework.base.BaseMapper
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