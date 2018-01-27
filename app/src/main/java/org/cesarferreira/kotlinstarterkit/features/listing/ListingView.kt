package org.cesarferreira.kotlinstarterkit.features.listing

import org.cesarferreira.kotlinstarterkit.MVP
import org.cesarferreira.kotlinstarterkit.data.entities.MovieEntity

interface ListingView : MVP.BaseView {
    fun displayData(data: List<MovieEntity>)
    fun hideLoading()
    fun showError(throwable: Throwable)
    fun showLoading()
}