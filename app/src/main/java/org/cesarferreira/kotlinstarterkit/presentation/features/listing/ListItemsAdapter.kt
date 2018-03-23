package org.cesarferreira.kotlinstarterkit.presentation.features.listing

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.bskyb.v3app.framework.extension.inflate
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_list_item.view.*
import org.cesarferreira.kotlinstarterkit.R
import org.cesarferreira.kotlinstarterkit.domain.entities.Movie

class ListItemsAdapter(private val picasso: Picasso,
                       private val items: ArrayList<Movie>,
                       private val onMovieClickListener: OnMovieClickListener)
    : RecyclerView.Adapter<ListItemsAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(parent.inflate(R.layout.movie_list_item))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val movie = items[position]
        holder.bind(picasso, movie)
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(picasso: Picasso, movie: Movie) {

            itemView.setOnClickListener { movie.id?.let { id -> onMovieClickListener.onClick(id) } }

            picasso.load(movie.poster)
                    .placeholder(R.color.black)
                    .error(R.color.picassoError)
                    .into(itemView.thumbnail)
        }
    }
}