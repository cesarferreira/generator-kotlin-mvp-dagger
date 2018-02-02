package org.cesarferreira.kotlinstarterkit.di

import dagger.Component
import org.cesarferreira.kotlinstarterkit.framework.BaseActivity
import org.cesarferreira.kotlinstarterkit.MyApplication
import org.cesarferreira.kotlinstarterkit.features.details.DetailsActivity
import org.cesarferreira.kotlinstarterkit.features.listing.ListItemsActivity
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        ApplicationModule::class,
        ImageLoadingModule::class,
        NetworkModule::class)
)
interface ApplicationComponent {
    fun inject(target: BaseActivity)
    fun inject(target: ListItemsActivity)
    fun inject(target: DetailsActivity)
    fun inject(target: MyApplication)
}