package org.cesarferreira.kotlinstarterkit.features.listing

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.cesarferreira.kotlinstarterkit.MVP
import org.cesarferreira.kotlinstarterkit.data.network.MoviesService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ListItemsPresenter
@Inject constructor(private val service: MoviesService) : MVP.BasePresenter<ListItemsView>() {

    private lateinit var mView: ListItemsView

    override fun attachView(view: ListItemsView) {
        mView = view
    }

    fun fetchData() {
        subscription =
                service.getMovies()
                        .subscribeOn(Schedulers.io())// inject me
                        .observeOn(AndroidSchedulers.mainThread()) // inject me
                        .doOnSubscribe({ showLoading() })
                        .doOnComplete({ hideLoading() })
                        .subscribe(({ mView.displayData(it.data) }), ({ showError(it) }))

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