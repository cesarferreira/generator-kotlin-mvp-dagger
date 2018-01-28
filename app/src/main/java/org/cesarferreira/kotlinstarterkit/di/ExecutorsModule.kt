package org.cesarferreira.kotlinstarterkit.di


import org.cesarferreira.kotlinstarterkit.executor.BackgroundThread
import org.cesarferreira.kotlinstarterkit.executor.UIThread
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ExecutorsModule {

    @Provides
    @Singleton
    internal fun providesBackgroundThread(): BackgroundThread {
        return BackgroundThread()
    }

    @Singleton
    @Provides
    internal fun providesUIThread(): UIThread {
        return UIThread()
    }
}
