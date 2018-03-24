package cesarferreira.movies.presentation.features.details

import cesarferreira.movies.data.network.MoviesService
import cesarferreira.movies.presentation.framework.base.BasePresenter
import cesarferreira.movies.presentation.framework.schedulers.SchedulersProvider
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DetailsPresenter
@Inject constructor(private val service: MoviesService,
                    private val movieDetailsApiToMovieDetailsMapper: MovieDetailsApiToMovieDetailsMapper,
                    private val schedulersProvider: SchedulersProvider) : BasePresenter<DetailsView>() {

    private lateinit var mView: DetailsView

    override fun attachView(view: DetailsView) {
        mView = view
    }

    fun fetchData(id: String) {
        subscription = service.getMovieDetails(id)
                .toObservable()
                .map({ source -> movieDetailsApiToMovieDetailsMapper.transform(source) })
                .subscribeOn(schedulersProvider.io())
                .observeOn(schedulersProvider.mainThread())
                .doOnSubscribe({ mView.showLoading() })
                .doOnComplete({ mView.hideLoading() })
                .subscribe(
                        { data -> mView.displayDetails(data) },
                        { error -> mView.showError(error) }
                )
    }
}