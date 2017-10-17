package annasblackhat.com.daggerarchcomponentsyncadapter.di

import annasblackhat.com.daggerarchcomponentsyncadapter.data.local.WeatherDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Git Solution on 17/10/2017.
 */

@Module
class DaoModule {

    @Singleton
    @Provides
    fun provideForecastDao(db: WeatherDatabase) = db.forecastDao()
}