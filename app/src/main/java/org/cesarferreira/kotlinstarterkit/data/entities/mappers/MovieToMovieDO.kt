package org.cesarferreira.kotlinstarterkit.data.entities.mappers

import org.cesarferreira.kotlinstarterkit.data.entities.MovieEntity
import org.cesarferreira.kotlinstarterkit.data.models.MovieDO
import org.cesarferreira.kotlinstarterkit.framework.base.BaseMapper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieToMovieDO
@Inject constructor()
    : BaseMapper<MovieEntity, MovieDO>() {

    override fun transform(source: MovieEntity): MovieDO {
        return MovieDO(source.id, source.poster)
    }
}