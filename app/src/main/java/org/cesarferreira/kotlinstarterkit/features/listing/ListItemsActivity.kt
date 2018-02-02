package org.cesarferreira.kotlinstarterkit.features.listing

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import org.cesarferreira.kotlinstarterkit.R
import org.cesarferreira.kotlinstarterkit.framework.BaseActivity
import org.cesarferreira.kotlinstarterkit.data.models.MovieDO
import org.cesarferreira.kotlinstarterkit.navigation.Navigator
import javax.inject.Inject

class ListItemsActivity : BaseActivity(), ListItemsView {

    @Inject lateinit var navigator: Navigator
    @Inject lateinit var picasso: Picasso
    @Inject lateinit var presenter: ListItemsPresenter

    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var adapter: ListItemsAdapter

    private var items = ArrayList<MovieDO>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        appComponent.inject(this)

        presenter.attachView(this)

        setupRecyclerView()

        presenter.fetchData()
    }


    private fun setupRecyclerView() {
        recyclerView.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager

        adapter = ListItemsAdapter(picasso, items, object : OnMovieClickListener {
            override fun onClick(id: String) {
                navigator.navigateToDetails(applicationContext, id)
            }
        })

        recyclerView.adapter = adapter

    }

    override fun displayData(data: List<MovieDO>) {
        items.addAll(data)
        adapter.notifyDataSetChanged()
    }

    override fun hideLoading() {
        progressBar.visibility = GONE
    }

    override fun showError(throwable: Throwable) {
        progressBar.visibility = GONE
        Toast.makeText(applicationContext, throwable.message, Toast.LENGTH_LONG).show()
    }

    override fun showLoading() {
        progressBar.visibility = VISIBLE
    }

    override fun onDestroy() {
        super.onDestroy()

        presenter.onDestroy()
    }
}
