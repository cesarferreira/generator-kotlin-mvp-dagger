package org.cesarferreira.kotlinstarterkit.features.listing

import org.cesarferreira.kotlinstarterkit.data.models.MovieDO
import org.cesarferreira.kotlinstarterkit.features.common.ErrorView
import org.cesarferreira.kotlinstarterkit.features.common.LoadingView
import org.cesarferreira.kotlinstarterkit.framework.base.BaseView

interface ListItemsView : BaseView, LoadingView, ErrorView {
    fun displayData(data: List<MovieDO>)
}