package org.cesarferreira.kotlinstarterkit.presentation.features.listing

import org.cesarferreira.kotlinstarterkit.data.models.mappers.MovieApiToMovieMapper
import org.cesarferreira.kotlinstarterkit.data.network.MoviesService
import org.cesarferreira.kotlinstarterkit.domain.executor.BackgroundThread
import org.cesarferreira.kotlinstarterkit.domain.executor.UIThread
import org.cesarferreira.kotlinstarterkit.presentation.framework.base.BasePresenter
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ListItemsPresenter
@Inject constructor(private val service: MoviesService,
                    private val movieApiToMovieMapper: MovieApiToMovieMapper,
                    private val backgroundThread: BackgroundThread,
                    private val uiThread: UIThread) : BasePresenter<ListItemsView>() {

    private lateinit var mView: ListItemsView

    override fun attachView(view: ListItemsView) {
        mView = view
    }

    fun fetchData() {
        subscription = service.getMovies()
                .toObservable()
                .map({ source -> movieApiToMovieMapper.transform(source.data) })
                .subscribeOn(backgroundThread.ioScheduler)
                .observeOn(uiThread.scheduler)
                .doOnSubscribe({ mView.showLoading() })
                .doOnComplete({ mView.hideLoading() })
                .subscribe(
                        { data -> mView.displayData(data) },
                        { error -> mView.showError(error) }
                )
    }
}