package cesarferreira.movies.di


import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class SystemModule {

    @Provides
    @Singleton
    protected fun providesSharedPreferences(context: Context): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }

    @Singleton
    @Provides
    protected fun providesSchedulers(): cesarferreira.movies.framework.schedulers.SchedulersProvider {
        return cesarferreira.movies.framework.schedulers.SchedulersProviderImpl()
    }
}
