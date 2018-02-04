package org.cesarferreira.kotlinstarterkit.features.details

import org.cesarferreira.kotlinstarterkit.data.entities.mappers.MovieDetailsEntityToMovieDetailsDO
import org.cesarferreira.kotlinstarterkit.data.network.MoviesService
import org.cesarferreira.kotlinstarterkit.framework.base.BasePresenter
import org.cesarferreira.kotlinstarterkit.framework.executor.BackgroundThread
import org.cesarferreira.kotlinstarterkit.framework.executor.UIThread
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DetailsPresenter
@Inject constructor(private val service: MoviesService,
                    private val movieDetailsEntityToMovieDetailsDO: MovieDetailsEntityToMovieDetailsDO,
                    private val backgroundThread: BackgroundThread,
                    private val uiThread: UIThread) : BasePresenter<DetailsView>() {

    private lateinit var mView: DetailsView

    override fun attachView(view: DetailsView) {
        mView = view
    }

    fun fetchData(id: String) {
        subscription = service.getMovieDetails(id)
                .toObservable()
                .map({ source -> movieDetailsEntityToMovieDetailsDO.transform(source) })
                .subscribeOn(backgroundThread.ioScheduler)
                .observeOn(uiThread.scheduler)
                .doOnSubscribe({ mView.showLoading() })
                .doOnComplete({ mView.hideLoading() })
                .subscribe(
                        { data -> mView.displayDetails(data) },
                        { error -> mView.showError(error) }
                )
    }
}