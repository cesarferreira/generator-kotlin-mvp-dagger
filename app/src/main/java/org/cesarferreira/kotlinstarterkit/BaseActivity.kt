package org.cesarferreira.kotlinstarterkit

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.cesarferreira.kotlinstarterkit.di.AppComponent

open class BaseActivity : AppCompatActivity() {

    private val appComponent: AppComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        (application as MyApplication).appComponent
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this);
    }
}