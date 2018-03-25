package cesarferreira.movies.features.details

import cesarferreira.movies.data.network.MoviesService
import cesarferreira.movies.framework.base.BasePresenter
import cesarferreira.movies.framework.schedulers.SchedulersProvider
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DetailsPresenter
@Inject constructor(private val service: MoviesService,
                    private val movieDetailsApiToMovieDetailsMapper: MovieDetailsApiToMovieDetailsMapper,
                    private val schedulersProvider: SchedulersProvider)
    : BasePresenter<DetailsView>() {

    fun fetchData(id: String) {
        compositeDisposable.add(service.getMovieDetails(id)
                .toObservable()
                .map({ source -> movieDetailsApiToMovieDetailsMapper.transform(source) })
                .subscribeOn(schedulersProvider.io())
                .observeOn(schedulersProvider.mainThread())
                .doOnSubscribe({ view!!.showLoading() })
                .doOnComplete({ view!!.hideLoading() })
                .subscribe(
                        { data -> view!!.displayDetails(data) },
                        { error -> view!!.showError(error) }
                )
        )
    }
}