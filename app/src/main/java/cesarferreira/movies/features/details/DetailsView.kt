package cesarferreira.movies.features.details

import cesarferreira.movies.features.common.ErrorView
import cesarferreira.movies.features.common.LoadingView
import cesarferreira.movies.framework.base.BaseView

interface DetailsView : BaseView, LoadingView, ErrorView {
    fun displayDetails(movie: MovieDetailsViewModel)
}