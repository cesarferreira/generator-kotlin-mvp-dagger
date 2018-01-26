package org.cesarferreira.kotlinstarterkit

import android.app.Application
import org.cesarferreira.kotlinstarterkit.di.*

class MyApplication : Application() {

    val appComponent: AppComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerAppComponent.builder()
                .appModule(ApplicationModule(this))
                .imageModule(ImageLoadingModule())
                .netModule(NetworkModule("https://movies-sample.herokuapp.com/"))
                .build()
    }

    override fun onCreate() {
        super.onCreate()

        appComponent.inject(this)
    }
}
