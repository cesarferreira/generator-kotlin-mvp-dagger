package org.cesarferreira.kotlinstarterkit.features.listing

import org.cesarferreira.kotlinstarterkit.data.entities.mappers.MovieEntityToMovieDO
import org.cesarferreira.kotlinstarterkit.data.network.MoviesService
import org.cesarferreira.kotlinstarterkit.framework.base.BasePresenter
import org.cesarferreira.kotlinstarterkit.framework.executor.BackgroundThread
import org.cesarferreira.kotlinstarterkit.framework.executor.UIThread
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ListItemsPresenter
@Inject constructor(private val service: MoviesService,
                    private val movieEntityToMovieDO: MovieEntityToMovieDO,
                    private val backgroundThread: BackgroundThread,
                    private val uiThread: UIThread) : BasePresenter<ListItemsView>() {

    private lateinit var mView: ListItemsView

    override fun attachView(view: ListItemsView) {
        mView = view
    }

    fun fetchData() {
        subscription = service.getMovies()
                .toObservable()
                .map({ source -> movieEntityToMovieDO.transform(source.data) })
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