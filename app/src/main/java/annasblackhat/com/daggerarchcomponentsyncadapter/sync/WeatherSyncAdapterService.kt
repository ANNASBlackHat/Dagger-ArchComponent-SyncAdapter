package annasblackhat.com.daggerarchcomponentsyncadapter.sync

import android.app.Service
import android.content.Intent
import dagger.android.AndroidInjection
import javax.inject.Inject

/**
 * Created by Git Solution on 17/10/2017.
 */
class WeatherSyncAdapterService: Service() {

    @Inject
    lateinit var syncAdapter: WeatherSyncAdapter

    override fun onCreate() {
        AndroidInjection.inject(this)
    }

    override fun onBind(p0: Intent?) = syncAdapter.syncAdapterBinder
}