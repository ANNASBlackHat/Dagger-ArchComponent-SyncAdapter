package annasblackhat.com.daggerarchcomponentsyncadapter.sync

import android.app.Service
import android.content.Intent

/**
 * Created by Git Solution on 17/10/2017.
 */
class WeatherAuthenticatorService: Service() {
    lateinit var mAuthenticator: WeatherAuthenticator
    override fun onCreate() {
        mAuthenticator = WeatherAuthenticator(this)
    }
    override fun onBind(p0: Intent?) = mAuthenticator.iBinder
}