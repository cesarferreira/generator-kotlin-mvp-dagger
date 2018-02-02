package org.cesarferreira.kotlinstarterkit.data.entities.mappers

import org.cesarferreira.kotlinstarterkit.framework.BaseMapper
import org.cesarferreira.kotlinstarterkit.data.entities.MovieEntity
import org.cesarferreira.kotlinstarterkit.data.models.MovieDO
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieEntityToMovieDO
@Inject constructor() : BaseMapper<MovieEntity, MovieDO>() {
    override fun transform(toBeTransformed: MovieEntity): MovieDO {
        return MovieDO(
                toBeTransformed.id,
                toBeTransformed.title,
                toBeTransformed.year,
                toBeTransformed.genre,
                toBeTransformed.plot,
                toBeTransformed.poster)
    }

}