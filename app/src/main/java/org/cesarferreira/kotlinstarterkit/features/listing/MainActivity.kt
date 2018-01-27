package org.cesarferreira.kotlinstarterkit.features.listing

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View.GONE
import android.view.View.VISIBLE
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import org.cesarferreira.kotlinstarterkit.BaseActivity
import org.cesarferreira.kotlinstarterkit.R
import org.cesarferreira.kotlinstarterkit.data.entities.MovieEntity
import org.cesarferreira.kotlinstarterkit.navigation.Navigator
import javax.inject.Inject

class MainActivity : BaseActivity(), ListingView {

    @Inject
    lateinit var navigator: Navigator

    @Inject
    lateinit var picasso: Picasso

    @Inject
    lateinit var presenter: ListingPresenter

    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var adapter: ListRecyclerViewAdapter

    private var items = ArrayList<MovieEntity>()

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

        adapter = ListRecyclerViewAdapter(picasso, items)
        recyclerView.adapter = adapter

    }

    override fun displayData(data: List<MovieEntity>) {
        items.addAll(data)
        adapter.notifyDataSetChanged()
    }

    override fun hideLoading() {
        progressBar.visibility = GONE
    }

    override fun showError(throwable: Throwable) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showLoading() {
        progressBar.visibility = VISIBLE
    }

    override fun onDestroy() {
        super.onDestroy()

        presenter.onDestroy()
    }
}
