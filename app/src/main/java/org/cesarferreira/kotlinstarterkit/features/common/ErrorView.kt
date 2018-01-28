package org.cesarferreira.kotlinstarterkit.features.common

interface ErrorView {
    fun showError(throwable: Throwable)
}