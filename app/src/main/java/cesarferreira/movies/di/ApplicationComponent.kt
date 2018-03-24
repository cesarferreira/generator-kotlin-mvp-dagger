package cesarferreira.movies.di

import dagger.Component
import cesarferreira.movies.MyApplication
import cesarferreira.movies.presentation.features.details.DetailsFragment
import cesarferreira.movies.presentation.features.listing.ListItemsFragment
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        ApplicationModule::class,
        ImageLoadingModule::class,
        NetworkModule::class,
        SystemModule::class)
)
interface ApplicationComponent {
    fun inject(target: MyApplication)
    fun inject(target: ListItemsFragment)
    fun inject(target: DetailsFragment)
}