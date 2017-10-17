package annasblackhat.com.daggerarchcomponentsyncadapter.di

import annasblackhat.com.daggerarchcomponentsyncadapter.data.remote.service.WeatherService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by Git Solution on 17/10/2017.
 */

@Module
class ServiceNetworkModule {

    @Singleton
    @Provides
    fun provideWeatherService(retrofit: Retrofit): WeatherService = retrofit.create(WeatherService::class.java)
}