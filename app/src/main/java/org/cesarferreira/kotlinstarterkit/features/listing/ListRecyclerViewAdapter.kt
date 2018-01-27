package org.cesarferreira.kotlinstarterkit.features.listing

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_list_row.view.*
import org.cesarferreira.kotlinstarterkit.R
import org.cesarferreira.kotlinstarterkit.data.entities.MovieEntity

class ListRecyclerViewAdapter(private val picasso: Picasso, private val items: List<MovieEntity>)
    : RecyclerView.Adapter<ListRecyclerViewAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent?.context).inflate(R.layout.movie_list_row, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ItemViewHolder?, position: Int) {
        val movie = items[position]

        (holder as ItemViewHolder)
                .bind(picasso, movie.title, movie.genre, movie.id.toString())
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(picasso: Picasso, title: String, year: String, genre: String) {
            itemView.title.text = title
            itemView.year.text = year
            itemView.genre.text = genre
        }
    }
}