package annasblackhat.com.daggerarchcomponentsyncadapter.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import annasblackhat.com.daggerarchcomponentsyncadapter.viewmodel.ViewModelFactory
import annasblackhat.com.daggerarchcomponentsyncadapter.viewmodel.WeatherViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Git Solution on 17/10/2017.
 */

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(WeatherViewModel::class)
    abstract fun bindsWeatherViewModel(weatherViewModel: WeatherViewModel): ViewModel

    @Binds
    abstract fun bindsViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}