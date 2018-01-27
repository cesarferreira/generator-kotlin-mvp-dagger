package org.cesarferreira.kotlinstarterkit

import android.support.v7.app.AppCompatActivity
import org.cesarferreira.kotlinstarterkit.di.ApplicationComponent

open class BaseActivity : AppCompatActivity() {

    protected val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        (application as MyApplication).appComponent
    }


//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        appComponent.inject(this);
//    }
}