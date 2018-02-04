package org.cesarferreira.kotlinstarterkit.features.details

import org.cesarferreira.kotlinstarterkit.data.entities.mappers.MovieEntityToMovieDetailsDO
import org.cesarferreira.kotlinstarterkit.data.network.MoviesService
import org.cesarferreira.kotlinstarterkit.framework.base.BasePresenter
import org.cesarferreira.kotlinstarterkit.framework.executor.BackgroundThread
import org.cesarferreira.kotlinstarterkit.framework.executor.UIThread
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DetailsPresenter
@Inject constructor(private val service: MoviesService,
                    private val movieEntityToMovieDetailsDO: MovieEntityToMovieDetailsDO,
                    private val backgroundThread: BackgroundThread,
                    private val uiThread: UIThread) : BasePresenter<DetailsView>() {

    private lateinit var mView: DetailsView

    override fun attachView(view: DetailsView) {
        mView = view
    }

    fun fetchData(id: String) {
        subscription = service.getMovieDetails(id)
                .map({ movieEntityToMovieDetailsDO.transform(it) })
                .subscribeOn(backgroundThread.ioScheduler)
                .observeOn(uiThread.scheduler)
                .doOnSubscribe({ showLoading() })
                .doOnComplete({ hideLoading() })
                .subscribe({ mView.displayDetails(it) }, { showError(it) })

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