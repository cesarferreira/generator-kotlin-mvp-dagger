package org.cesarferreira.kotlinstarterkit.features.listing

import org.cesarferreira.kotlinstarterkit.base.MVP
import org.cesarferreira.kotlinstarterkit.data.network.MoviesService
import org.cesarferreira.kotlinstarterkit.executor.BackgroundThread
import org.cesarferreira.kotlinstarterkit.executor.UIThread
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ListItemsPresenter
@Inject constructor(private val service: MoviesService,
                    private val backgroundThread: BackgroundThread,
                    private val uiThread: UIThread) : MVP.BasePresenter<ListItemsView>() {

    private lateinit var mView: ListItemsView

    override fun attachView(view: ListItemsView) {
        mView = view
    }

    fun fetchData() {
        subscription =
                service.getMovies()
                        .subscribeOn(backgroundThread.ioScheduler)
                        .observeOn(uiThread.scheduler)
                        .doOnSubscribe({ showLoading() })
                        .doOnComplete({ hideLoading() })
                        .subscribe({ mView.displayData(it.data) }, { showError(it) })
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