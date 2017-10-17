package annasblackhat.com.daggerarchcomponentsyncadapter.app

import android.app.Activity
import android.app.Application
import android.app.Service
import annasblackhat.com.daggerarchcomponentsyncadapter.di.AppComponent
import annasblackhat.com.daggerarchcomponentsyncadapter.di.DaggerAppComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.HasServiceInjector
import javax.inject.Inject

/**
 * Created by Git Solution on 17/10/2017.
 */
class WeatherApp : Application(), HasActivityInjector, HasServiceInjector {

    @Inject
    lateinit var activityDispatchingInjector: DispatchingAndroidInjector<Activity>
    @Inject
    lateinit var serviceDispatchingInjector: DispatchingAndroidInjector<Service>

    private val component: AppComponent by lazy {
        DaggerAppComponent.builder()
                .application(this)
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }

    override fun activityInjector() = activityDispatchingInjector
    override fun serviceInjector() = serviceDispatchingInjector
}