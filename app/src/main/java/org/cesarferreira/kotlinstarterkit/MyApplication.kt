package org.cesarferreira.kotlinstarterkit

import android.app.Application
import com.squareup.leakcanary.LeakCanary
import org.cesarferreira.kotlinstarterkit.di.*

class MyApplication : Application() {

    companion object {
        const val BASE_URL: String = "https://movie-sample-api.herokuapp.com/"
    }

    val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .imageLoadingModule(ImageLoadingModule())
                .networkModule(NetworkModule(BASE_URL))
                .build()
    }

    override fun onCreate() {
        super.onCreate()

        appComponent.inject(this)

        if (BuildConfig.DEBUG) {
            LeakCanary.install(this)
        }
    }
}
