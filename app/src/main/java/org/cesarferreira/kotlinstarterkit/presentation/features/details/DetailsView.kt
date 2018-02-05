package org.cesarferreira.kotlinstarterkit.presentation.features.details

import org.cesarferreira.kotlinstarterkit.domain.entities.MovieDetails
import org.cesarferreira.kotlinstarterkit.presentation.features.common.ErrorView
import org.cesarferreira.kotlinstarterkit.presentation.features.common.LoadingView
import org.cesarferreira.kotlinstarterkit.presentation.framework.base.BaseView

interface DetailsView : BaseView, LoadingView, ErrorView {
    fun displayDetails(movie: MovieDetails)
}