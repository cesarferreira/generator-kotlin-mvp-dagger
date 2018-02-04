package org.cesarferreira.kotlinstarterkit.di

import dagger.Component
import org.cesarferreira.kotlinstarterkit.MyApplication
import org.cesarferreira.kotlinstarterkit.features.details.DetailsFragment
import org.cesarferreira.kotlinstarterkit.features.listing.ListItemsFragment
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        ApplicationModule::class,
        ImageLoadingModule::class,
        NetworkModule::class)
)
interface ApplicationComponent {
    fun inject(target: MyApplication)
    fun inject(target: ListItemsFragment)
    fun inject(target: DetailsFragment)
}