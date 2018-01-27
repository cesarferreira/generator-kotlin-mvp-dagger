package org.cesarferreira.kotlinstarterkit.di

import dagger.Component
import org.cesarferreira.kotlinstarterkit.BaseActivity
import org.cesarferreira.kotlinstarterkit.MyApplication
import org.cesarferreira.kotlinstarterkit.features.listing.MainActivity
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class, ImageLoadingModule::class, NetworkModule::class))
interface ApplicationComponent {
    fun inject(target: BaseActivity)
    fun inject(target: MainActivity)
    fun inject(target: MyApplication)
}