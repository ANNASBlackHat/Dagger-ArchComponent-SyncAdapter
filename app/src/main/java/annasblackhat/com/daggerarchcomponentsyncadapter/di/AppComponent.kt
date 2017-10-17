package annasblackhat.com.daggerarchcomponentsyncadapter.di

import android.app.Application
import annasblackhat.com.daggerarchcomponentsyncadapter.app.WeatherApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * Created by Git Solution on 17/10/2017.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, AndroidInjectionModule::class, ActivityBuilderModule::class))
interface AppComponent {

    @Component.Builder
    interface Builder{
        @BindsInstance fun application(app: Application): Builder
        fun build(): AppComponent
    }

    fun inject(app: WeatherApp)
}