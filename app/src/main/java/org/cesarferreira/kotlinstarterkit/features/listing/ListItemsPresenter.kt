package org.cesarferreira.kotlinstarterkit.features.listing

import org.cesarferreira.kotlinstarterkit.framework.BasePresenter
import org.cesarferreira.kotlinstarterkit.data.entities.mappers.MovieEntityToMovieDO
import org.cesarferreira.kotlinstarterkit.data.network.MoviesService
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
                .map({ movieEntityToMovieDO.transform(it.data) })
                .subscribeOn(backgroundThread.ioScheduler)
                .observeOn(uiThread.scheduler)
                .doOnSubscribe({ showLoading() })
                .doOnComplete({ hideLoading() })
                .subscribe({ mView.displayData(it) }, { showError(it) })
    }

    private fun showLoading() {
        mView.showLoading()
    }

    private fun hideLoading() {
        mView.hideLoading()
    }

    private fun showError(throwable: Throwable) {
        mView.hideLoading()
        mView.showError(throwable)
    }
}