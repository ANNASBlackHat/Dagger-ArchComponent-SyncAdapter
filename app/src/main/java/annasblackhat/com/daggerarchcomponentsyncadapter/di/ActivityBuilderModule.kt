package annasblackhat.com.daggerarchcomponentsyncadapter.di

import annasblackhat.com.daggerarchcomponentsyncadapter.sync.WeatherSyncAdapterService
import annasblackhat.com.daggerarchcomponentsyncadapter.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Git Solution on 17/10/2017.
 */

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = arrayOf(FragmentBuilderModule::class))
    abstract fun mainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun syncAdapterService(): WeatherSyncAdapterService
}