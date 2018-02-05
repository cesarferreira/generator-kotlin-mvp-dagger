package org.cesarferreira.kotlinstarterkit.presentation.features.details

import org.cesarferreira.kotlinstarterkit.data.models.mappers.MovieDetailsApiToMovieDetailsMapper
import org.cesarferreira.kotlinstarterkit.data.network.MoviesService
import org.cesarferreira.kotlinstarterkit.domain.executor.BackgroundThread
import org.cesarferreira.kotlinstarterkit.domain.executor.UIThread
import org.cesarferreira.kotlinstarterkit.presentation.framework.base.BasePresenter
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DetailsPresenter
@Inject constructor(private val service: MoviesService,
                    private val movieDetailsApiToMovieDetailsMapper: MovieDetailsApiToMovieDetailsMapper,
                    private val backgroundThread: BackgroundThread,
                    private val uiThread: UIThread) : BasePresenter<DetailsView>() {

    private lateinit var mView: DetailsView

    override fun attachView(view: DetailsView) {
        mView = view
    }

    fun fetchData(id: String) {
        subscription = service.getMovieDetails(id)
                .toObservable()
                .map({ source -> movieDetailsApiToMovieDetailsMapper.transform(source) })
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