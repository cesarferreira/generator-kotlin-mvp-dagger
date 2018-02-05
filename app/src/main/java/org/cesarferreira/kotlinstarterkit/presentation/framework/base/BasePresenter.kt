package org.cesarferreira.kotlinstarterkit.presentation.framework.base

import io.reactivex.disposables.Disposable

abstract class BasePresenter<in T : BaseView> {

    var subscription: Disposable? = null

    /**
     * Method dependency injection, so we are able to @Inject our presenters and lazyly attachView(view)
     *
     * @param view
     */
    abstract fun attachView(view: T)

    /**
     * Call this method when the activity/fragment is being destroyed
     */
    fun onDestroy() {
        if (this.subscription != null && !this.subscription!!.isDisposed) {
            this.subscription!!.dispose()
        }
    }
}