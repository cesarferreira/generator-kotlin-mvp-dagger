package org.cesarferreira.kotlinstarterkit.presentation.framework.base


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.cesarferreira.kotlinstarterkit.MyApplication
import org.cesarferreira.kotlinstarterkit.di.ApplicationComponent


abstract class BaseFragment : Fragment() {
    init {
        retainInstance = true
    }

    abstract fun layoutId(): Int

    val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        (activity?.application as MyApplication).appComponent
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(layoutId(), container, false)
    }

    open fun onBackPressed() {}

    internal fun firstTimeCreated(savedInstanceState: Bundle?) = savedInstanceState == null
}