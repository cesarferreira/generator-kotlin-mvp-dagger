package cesarferreira.movies.di

import cesarferreira.movies.MyApplication
import cesarferreira.movies.features.details.DetailsFragment
import cesarferreira.movies.features.listing.ListItemsFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        ApplicationModule::class,
        NetworkModule::class,
        SystemModule::class)
)
interface ApplicationComponent {
    fun inject(target: MyApplication)
    fun inject(target: ListItemsFragment)
    fun inject(target: DetailsFragment)
}