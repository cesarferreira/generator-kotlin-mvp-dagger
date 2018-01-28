package org.cesarferreira.kotlinstarterkit.features.listing

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_list_row.view.*
import org.cesarferreira.kotlinstarterkit.R
import org.cesarferreira.kotlinstarterkit.data.entities.MovieEntity

class ListItemsAdapter(private val picasso: Picasso, private val items: List<MovieEntity>, private val onMovieClickListener: OnMovieClickListener)
    : RecyclerView.Adapter<ListItemsAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent?.context)
                .inflate(R.layout.movie_list_row, parent, false)

        return ItemViewHolder(itemView)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ItemViewHolder?, position: Int) {
        val movie = items[position]

        (holder as ItemViewHolder)
                .bind(picasso, movie)
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(picasso: Picasso, movie: MovieEntity) {
            itemView.title.text = movie.title
            itemView.year.text = movie.year
            itemView.genre.text = movie.genre

            itemView.setOnClickListener { onMovieClickListener.onClick(movie.id) }

            picasso.load(movie.poster)
                    .placeholder(R.color.picassoPlaceholder)
                    .error(R.color.picassoError)
                    .into(itemView.thumbnail)
        }
    }
}