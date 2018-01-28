package org.cesarferreira.kotlinstarterkit.features.details

import org.cesarferreira.kotlinstarterkit.base.MVP
import org.cesarferreira.kotlinstarterkit.data.entities.MovieEntity
import org.cesarferreira.kotlinstarterkit.features.common.ErrorView
import org.cesarferreira.kotlinstarterkit.features.common.LoadingView

interface DetailsView : MVP.BaseView, LoadingView, ErrorView {
    fun displayDetails(movieEntity: MovieEntity)
}