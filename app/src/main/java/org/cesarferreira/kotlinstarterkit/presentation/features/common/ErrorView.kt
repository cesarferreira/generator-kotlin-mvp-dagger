package org.cesarferreira.kotlinstarterkit.presentation.features.common

interface ErrorView {
    fun showError(throwable: Throwable)
}