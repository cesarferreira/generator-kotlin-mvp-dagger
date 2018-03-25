package cesarferreira.movies.features.listing

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import cesarferreira.faker.loadFromUrl
import cesarferreira.movies.R
import com.bskyb.v3app.framework.extension.inflate
import kotlinx.android.synthetic.main.movie_list_item.view.*

class ListItemsAdapter(private val items: ArrayList<MovieViewModel>,
                       private val onMovieClickListener: OnMovieClickListener)
    : RecyclerView.Adapter<ListItemsAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(parent.inflate(R.layout.movie_list_item))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val movie = items[position]
        holder.bind(movie)
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movie: MovieViewModel) {

            itemView.setOnClickListener { movie.id.let { id -> onMovieClickListener.onClick(id) } }

            itemView.thumbnail.loadFromUrl(url = movie.poster,
                    placeholder = R.color.black,
                    error = R.color.picassoError)
        }
    }
}
