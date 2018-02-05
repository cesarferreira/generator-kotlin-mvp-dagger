package org.cesarferreira.kotlinstarterkit.presentation.features.details

import android.os.Bundle
import android.view.View
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_details.*
import kotlinx.android.synthetic.main.toolbar.*
import org.cesarferreira.kotlinstarterkit.R
import org.cesarferreira.kotlinstarterkit.domain.entities.MovieDetails
import org.cesarferreira.kotlinstarterkit.presentation.features.common.Constants
import org.cesarferreira.kotlinstarterkit.presentation.framework.base.BaseFragment
import javax.inject.Inject

class DetailsFragment : BaseFragment(), DetailsView {

    override fun layoutId(): Int = R.layout.fragment_details

    @Inject lateinit var picasso: Picasso
    @Inject lateinit var presenter: DetailsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attachView(this)
        presenter.fetchData(activity!!.intent.getStringExtra(Constants.ITEM_KEY))
    }

    override fun displayDetails(movie: MovieDetails) {

        movieCast.text = movie.cast
        movieDirector.text = movie.director
        movieSummary.text = movie.summary
        movieYear.text = movie.year

        activity!!.toolbar.title = movie.title

        picasso.load(movie.poster)
                .placeholder(R.color.black)
                .error(R.color.picassoError)
                .into(moviePoster)
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
    }

    override fun showError(throwable: Throwable) {
        TODO()
    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

}

