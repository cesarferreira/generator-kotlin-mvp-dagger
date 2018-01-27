package org.cesarferreira.kotlinstarterkit.features.listing

import android.os.Bundle
import org.cesarferreira.kotlinstarterkit.BaseActivity
import org.cesarferreira.kotlinstarterkit.R
import org.cesarferreira.kotlinstarterkit.data.entities.MovieEntity
import org.cesarferreira.kotlinstarterkit.navigation.Navigator
import javax.inject.Inject

class MainActivity : BaseActivity(), ListingView {

    @Inject
    lateinit var navigator: Navigator

    @Inject
    lateinit var presenter: ListingPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        appComponent.inject(this)

        presenter.attachView(this)

        presenter.fetchData()
    }

    override fun displayData(data: List<MovieEntity>) {
        // TODO
        val str = "cesar"
    }

    override fun hideLoading() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showError(throwable: Throwable) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showLoading() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onDestroy() {
        super.onDestroy()

        presenter.onDestroy()
    }
}
