package cesarferreira.movies.framework.base

import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenter<T : BaseView> {

    protected val compositeDisposable: CompositeDisposable = CompositeDisposable()

    protected var view: T? = null

    open fun attachView(view: T?) {
        if (view == null) throw NullPointerException("View is null, maybe you want to use detachView instead")

        this.view = view
        if (compositeDisposable.isDisposed) compositeDisposable.clear()
    }

    open fun detachView() {
        this.view = null
        if (compositeDisposable.isDisposed) compositeDisposable.clear()
    }
}
