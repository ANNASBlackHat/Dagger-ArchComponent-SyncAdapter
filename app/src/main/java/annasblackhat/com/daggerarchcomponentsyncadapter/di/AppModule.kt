package annasblackhat.com.daggerarchcomponentsyncadapter.di

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import annasblackhat.com.daggerarchcomponentsyncadapter.BuildConfig
import annasblackhat.com.daggerarchcomponentsyncadapter.data.local.WeatherDatabase
import annasblackhat.com.daggerarchcomponentsyncadapter.util.Constant
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by Git Solution on 17/10/2017.
 */

@Module(includes = arrayOf(DaoModule::class, ViewModelModule::class, ServiceNetworkModule::class))
class AppModule {
    @Singleton
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        return interceptor
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()
        okHttpClient.connectTimeout(15, TimeUnit.SECONDS)
        okHttpClient.readTimeout(15, TimeUnit.SECONDS)
        okHttpClient.addInterceptor(interceptor)
        return okHttpClient.build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
    }

    @Singleton
    @Provides
    fun provideDatabase(app: Application): WeatherDatabase{
        return Room.databaseBuilder(app, WeatherDatabase::class.java, "weather.db").build()
    }

    @Singleton
    @Provides
    fun provideBoolean(): Boolean = true

    @Singleton
    @Provides
    fun provideContext(app: Application) = app.applicationContext
}