package org.cesarferreira.kotlinstarterkit.features.details

import android.os.Bundle
import android.view.View
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_details.*
import org.cesarferreira.kotlinstarterkit.R
import org.cesarferreira.kotlinstarterkit.data.models.MovieDO
import org.cesarferreira.kotlinstarterkit.features.common.Constants
import org.cesarferreira.kotlinstarterkit.framework.BaseFragment
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

    override fun displayDetails(movieDO: MovieDO) {

        movieCast.text = movieDO.cast
        movieDirector.text = movieDO.director
        movieSummary.text = movieDO.summary
        movieYear.text = movieDO.year

        picasso.load(movieDO.poster)
                .placeholder(R.color.black)
                .error(R.color.picassoError)
                .into(moviePoster)
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
    }

    override fun showError(throwable: Throwable) {
        // todo
    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

}

