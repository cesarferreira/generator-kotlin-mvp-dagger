package org.cesarferreira.kotlinstarterkit.features.listing

import org.cesarferreira.kotlinstarterkit.base.BaseView
import org.cesarferreira.kotlinstarterkit.data.models.MovieDO
import org.cesarferreira.kotlinstarterkit.features.common.ErrorView
import org.cesarferreira.kotlinstarterkit.features.common.LoadingView

interface ListItemsView : BaseView, LoadingView, ErrorView {
    fun displayData(data: List<MovieDO>)
}