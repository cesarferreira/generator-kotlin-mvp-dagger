package org.cesarferreira.kotlinstarterkit.di

import dagger.Component
import org.cesarferreira.kotlinstarterkit.BaseActivity
import org.cesarferreira.kotlinstarterkit.MainActivity
import org.cesarferreira.kotlinstarterkit.MyApplication
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class, ImageLoadingModule::class, NetworkModule::class))
interface AppComponent {
    fun inject(target: BaseActivity)
    fun inject(target: MainActivity)
    fun inject(target: MyApplication)
}