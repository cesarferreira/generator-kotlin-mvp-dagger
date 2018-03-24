package cesarferreira.movies

import android.app.Application
import cesarferreira.movies.data.network.Endpoints
import cesarferreira.movies.di.ApplicationComponent
import cesarferreira.movies.di.ApplicationModule
import cesarferreira.movies.di.DaggerApplicationComponent
import cesarferreira.movies.di.NetworkModule
import com.squareup.leakcanary.LeakCanary

class MyApplication : Application() {

    val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .networkModule(NetworkModule(Endpoints.BASE_URL))
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
