package annasblackhat.com.daggerarchcomponentsyncadapter.di

import annasblackhat.com.daggerarchcomponentsyncadapter.view.ForecastHomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Git Solution on 17/10/2017.
 */

@Module
abstract class FragmentBuilderModule {

    @ContributesAndroidInjector
    abstract fun forecastHomeFragment(): ForecastHomeFragment
}