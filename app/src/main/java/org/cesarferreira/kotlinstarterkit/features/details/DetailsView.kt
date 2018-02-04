package org.cesarferreira.kotlinstarterkit.features.details

import org.cesarferreira.kotlinstarterkit.data.models.MovieDetailsDO
import org.cesarferreira.kotlinstarterkit.features.common.ErrorView
import org.cesarferreira.kotlinstarterkit.features.common.LoadingView
import org.cesarferreira.kotlinstarterkit.framework.base.BaseView

interface DetailsView : BaseView, LoadingView, ErrorView {
    fun displayDetails(movieDO: MovieDetailsDO)
}