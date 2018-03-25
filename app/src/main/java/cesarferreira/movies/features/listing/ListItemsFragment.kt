package cesarferreira.movies.features.listing

import android.os.Bundle
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.View
import cesarferreira.movies.R
import cesarferreira.movies.framework.base.BaseFragment
import cesarferreira.movies.framework.extensions.showToast
import cesarferreira.movies.navigation.Navigator
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_list_items.*
import javax.inject.Inject

class ListItemsFragment : BaseFragment(), ListItemsView {

    @Inject lateinit var navigator: Navigator
    @Inject lateinit var presenter: ListItemsPresenter

    private lateinit var adapter: ListItemsAdapter
    private var items = ArrayList<MovieViewModel>()

    override fun layoutId(): Int = R.layout.fragment_list_items

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attachView(this)
        initializeViews()
        presenter.fetchData()
    }

    private fun initializeViews() {
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)

        adapter = ListItemsAdapter(items, object : OnMovieClickListener {
            override fun onClick(id: String) {
                context?.let { navigator.navigateToDetails(it, id) }
            }
        })

        recyclerView.adapter = adapter
    }

    override fun displayData(data: List<MovieViewModel>) {
        items.addAll(data)
        adapter.notifyDataSetChanged()
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
    }

    override fun showError(throwable: Throwable) {
        progressBar.visibility = View.GONE
        activity!!.showToast(throwable.localizedMessage)
    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }
}
