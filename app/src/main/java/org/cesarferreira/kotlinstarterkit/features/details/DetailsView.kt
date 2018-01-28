package org.cesarferreira.kotlinstarterkit.features.details

import org.cesarferreira.kotlinstarterkit.MVP
import org.cesarferreira.kotlinstarterkit.data.entities.MovieEntity

interface DetailsView : MVP.BaseView {
    fun displayDetails(movieEntity: MovieEntity)
    fun hideLoading()
    fun showError(throwable: Throwable)
    fun showLoading()
}