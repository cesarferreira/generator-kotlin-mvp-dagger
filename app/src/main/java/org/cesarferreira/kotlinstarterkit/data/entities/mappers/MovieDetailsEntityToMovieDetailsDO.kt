package org.cesarferreira.kotlinstarterkit.data.entities.mappers

import org.cesarferreira.kotlinstarterkit.data.entities.MovieDetailsEntity
import org.cesarferreira.kotlinstarterkit.data.models.MovieDetailsDO
import org.cesarferreira.kotlinstarterkit.framework.base.BaseMapper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieDetailsEntityToMovieDetailsDO
@Inject constructor() : BaseMapper<MovieDetailsEntity, MovieDetailsDO>() {
    override fun transform(source: MovieDetailsEntity): MovieDetailsDO {
        return MovieDetailsDO(
                source.id,
                source.title,
                source.year,
                source.cast,
                source.director,
                source.summary,
                source.poster)
    }

}