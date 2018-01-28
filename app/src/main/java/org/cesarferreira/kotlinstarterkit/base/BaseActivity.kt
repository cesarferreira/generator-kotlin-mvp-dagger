package org.cesarferreira.kotlinstarterkit.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.cesarferreira.kotlinstarterkit.MyApplication
import org.cesarferreira.kotlinstarterkit.di.ApplicationComponent

open class BaseActivity : AppCompatActivity() {

    protected val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        (application as MyApplication).appComponent
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
    }
}