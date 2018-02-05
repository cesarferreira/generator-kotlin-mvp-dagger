package org.cesarferreira.kotlinstarterkit.di


import dagger.Module
import dagger.Provides
import org.cesarferreira.kotlinstarterkit.domain.executor.BackgroundThread
import org.cesarferreira.kotlinstarterkit.domain.executor.UIThread
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
