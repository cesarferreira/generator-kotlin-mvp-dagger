package org.cesarferreira.kotlinstarterkit.features.details

import org.cesarferreira.kotlinstarterkit.base.BaseView
import org.cesarferreira.kotlinstarterkit.data.models.MovieDO
import org.cesarferreira.kotlinstarterkit.features.common.ErrorView
import org.cesarferreira.kotlinstarterkit.features.common.LoadingView

interface DetailsView : BaseView, LoadingView, ErrorView {
    fun displayDetails(movieDO: MovieDO)
}