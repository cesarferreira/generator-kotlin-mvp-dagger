package org.cesarferreira.kotlinstarterkit.features.details

import android.os.Bundle
import android.view.View
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_details.*
import org.cesarferreira.kotlinstarterkit.BaseActivity
import org.cesarferreira.kotlinstarterkit.R
import org.cesarferreira.kotlinstarterkit.data.entities.MovieEntity
import org.cesarferreira.kotlinstarterkit.features.common.Constants
import javax.inject.Inject


class DetailsActivity : BaseActivity(), DetailsView {

    @Inject lateinit var picasso: Picasso
    @Inject lateinit var presenter: DetailsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        appComponent.inject(this)

        presenter.attachView(this)

        presenter.fetchData(intent.getStringExtra(Constants.ITEM_KEY))
    }

    override fun displayDetails(movieEntity: MovieEntity) {
        picasso.load(movieEntity.poster)
                .placeholder(R.color.picassoPlaceholder)
                .error(R.color.picassoError)
                .into(posterImageView)
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
    }

    override fun showError(throwable: Throwable) {
    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

}
