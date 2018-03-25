package cesarferreira.movies.features.details

import cesarferreira.movies.framework.base.BasePresenter
import cesarferreira.movies.framework.schedulers.SchedulersProvider
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DetailsPresenter
@Inject constructor(private val getMovieDetailUseCase: GetMovieDetailUseCase,
                    private val movieDetailsToMovieDetailsViewModelMapper: MovieDetailsToMovieDetailsViewModelMapper,
                    private val schedulersProvider: SchedulersProvider)
    : BasePresenter<DetailsView>() {

    fun fetchData(id: String) {
        val params = GetMovieDetailUseCase.Params(id)

        compositeDisposable.add(getMovieDetailUseCase.buildUseCase(params)
                .toObservable()
                .map({ movieDetailsToMovieDetailsViewModelMapper.transform(it) })
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