package org.cesarferreira.kotlinstarterkit.presentation.features.listing

import org.cesarferreira.kotlinstarterkit.domain.entities.Movie
import org.cesarferreira.kotlinstarterkit.presentation.features.common.ErrorView
import org.cesarferreira.kotlinstarterkit.presentation.features.common.LoadingView
import org.cesarferreira.kotlinstarterkit.presentation.framework.base.BaseView

interface ListItemsView : BaseView, LoadingView, ErrorView {
    fun displayData(data: List<Movie>)
}