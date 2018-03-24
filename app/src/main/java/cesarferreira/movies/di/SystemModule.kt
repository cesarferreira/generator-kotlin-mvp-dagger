package cesarferreira.movies.di

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager


import cesarferreira.movies.presentation.framework.schedulers.SchedulersProvider
import cesarferreira.movies.presentation.framework.schedulers.SchedulersProviderImpl

import javax.inject.Singleton

import dagger.Module
import dagger.Provides

@Module
class SystemModule {

    @Provides
    @Singleton
    protected fun providesSharedPreferences(context: Context): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }

    @Singleton
    @Provides
    protected fun providesSchedulers(): SchedulersProvider {
        return SchedulersProviderImpl()
    }
}
