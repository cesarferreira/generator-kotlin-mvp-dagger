package org.cesarferreira.kotlinstarterkit.presentation.features.listing

import org.cesarferreira.kotlinstarterkit.data.models.mappers.MovieApiToMovieMapper
import org.cesarferreira.kotlinstarterkit.data.network.MoviesService
import org.cesarferreira.kotlinstarterkit.presentation.framework.base.BasePresenter
import org.cesarferreira.kotlinstarterkit.schedulers.SchedulersProvider
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ListItemsPresenter
@Inject constructor(private val service: MoviesService,
                    private val movieApiToMovieMapper: MovieApiToMovieMapper,
                    private val schedulersProvider: SchedulersProvider) : BasePresenter<ListItemsView>() {

    private lateinit var mView: ListItemsView

    override fun attachView(view: ListItemsView) {
        mView = view
    }

    fun fetchData() {
        subscription = service.getMovies()
                .toObservable()
                .map({ movieApiToMovieMapper.transform(it.data) })
                .subscribeOn(schedulersProvider.io())
                .observeOn(schedulersProvider.mainThread())
                .doOnSubscribe({ mView.showLoading() })
                .doOnComplete({ mView.hideLoading() })
                .subscribe(
                        { data -> mView.displayData(data) },
                        { error -> mView.showError(error) }
                )
    }
}