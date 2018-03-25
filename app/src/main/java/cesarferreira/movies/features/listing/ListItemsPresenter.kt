package cesarferreira.movies.features.listing

import cesarferreira.movies.data.network.MoviesService
import cesarferreira.movies.framework.base.BasePresenter
import cesarferreira.movies.framework.schedulers.SchedulersProvider
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ListItemsPresenter
@Inject constructor(private val service: MoviesService,
                    private val movieApiToMovieMapper: MovieApiToMovieMapper,
                    private val schedulersProvider: SchedulersProvider)
    : BasePresenter<ListItemsView>() {

    fun fetchData() {
        compositeDisposable.add(service.getMovies()
                .toObservable()
                .map({ movieApiToMovieMapper.transform(it.data) })
                .subscribeOn(schedulersProvider.io())
                .observeOn(schedulersProvider.mainThread())
                .doOnSubscribe({ view!!.showLoading() })
                .doOnComplete({ view!!.hideLoading() })
                .subscribe(
                        { data -> view!!.displayData(data) },
                        { error -> view!!.showError(error) }
                )
        )
    }
}