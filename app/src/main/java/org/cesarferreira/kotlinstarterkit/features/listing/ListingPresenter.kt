package org.cesarferreira.kotlinstarterkit.features.listing

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.cesarferreira.kotlinstarterkit.MVP
import org.cesarferreira.kotlinstarterkit.data.network.MoviesService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ListingPresenter
@Inject constructor(private val service: MoviesService) : MVP.BasePresenter<ListingView>() {

    private lateinit var mView: ListingView

    override fun attachView(view: ListingView) {
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