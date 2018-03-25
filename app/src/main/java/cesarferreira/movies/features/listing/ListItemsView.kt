package cesarferreira.movies.features.listing

import cesarferreira.movies.features.common.ErrorView
import cesarferreira.movies.features.common.LoadingView
import cesarferreira.movies.framework.base.BaseView

interface ListItemsView : BaseView, LoadingView, ErrorView {
    fun displayData(data: List<MovieViewModel>)
}