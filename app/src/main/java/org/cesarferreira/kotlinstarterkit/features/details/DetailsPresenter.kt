package org.cesarferreira.kotlinstarterkit.features.details

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.cesarferreira.kotlinstarterkit.MVP
import org.cesarferreira.kotlinstarterkit.data.network.MoviesService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DetailsPresenter
@Inject constructor(private val service: MoviesService)
    : MVP.BasePresenter<DetailsView>() {

    private lateinit var mView: DetailsView

    override fun attachView(view: DetailsView) {
        mView = view
    }

    fun fetchData(id: String) {
        subscription =
                service.getMovieDetails(id)
                        .subscribeOn(Schedulers.io())// inject me
                        .observeOn(AndroidSchedulers.mainThread()) // inject me
                        .doOnSubscribe({ showLoading() })
                        .doOnComplete({ hideLoading() })
                        .subscribe(({ mView.displayDetails(it) }), ({ showError(it) }))

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