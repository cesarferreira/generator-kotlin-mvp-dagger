package cesarferreira.movies.features.listing

import cesarferreira.movies.framework.base.BasePresenter
import cesarferreira.movies.framework.base.BaseUseCase
import cesarferreira.movies.framework.schedulers.SchedulersProvider
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ListItemsPresenter
@Inject constructor(private val movieToMovieViewModelMapper: MovieToMovieViewModelMapper,
                    private val getMoviesUseCase: GetMoviesUseCase,
                    private val schedulersProvider: SchedulersProvider)
    : BasePresenter<ListItemsView>() {

    fun fetchData() {

        val params = BaseUseCase.None()

        compositeDisposable.add(
                getMoviesUseCase.buildUseCase(params)
                        .toObservable()
                        .map({ movieToMovieViewModelMapper.transform(it) })
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