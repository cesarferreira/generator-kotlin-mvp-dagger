package cesarferreira.movies.presentation.features.details

import cesarferreira.movies.presentation.features.common.ErrorView
import cesarferreira.movies.presentation.features.common.LoadingView
import cesarferreira.movies.presentation.framework.base.BaseView

interface DetailsView : BaseView, LoadingView, ErrorView {
    fun displayDetails(movie: MovieDetails)
}