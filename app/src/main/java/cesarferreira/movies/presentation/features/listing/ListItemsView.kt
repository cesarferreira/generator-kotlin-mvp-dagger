package cesarferreira.movies.presentation.features.listing

import cesarferreira.movies.domain.Movie
import cesarferreira.movies.presentation.features.common.ErrorView
import cesarferreira.movies.presentation.features.common.LoadingView
import cesarferreira.movies.presentation.framework.base.BaseView

interface ListItemsView : BaseView, LoadingView, ErrorView {
    fun displayData(data: List<Movie>)
}