package annasblackhat.com.daggerarchcomponentsyncadapter.sync

import android.accounts.Account
import android.accounts.AccountManager
import android.content.*
import android.os.Build
import android.os.Bundle
import annasblackhat.com.daggerarchcomponentsyncadapter.R
import annasblackhat.com.daggerarchcomponentsyncadapter.data.remote.repository.WeatherRepository
import javax.inject.Inject

/**
 * Created by Git Solution on 17/10/2017.
 */
class WeatherSyncAdapter @Inject
constructor(context: Context, autoInitialize: Boolean, private val weatherRepository: WeatherRepository) :
        AbstractThreadedSyncAdapter(context, autoInitialize){

    override fun onPerformSync(p0: Account?, p1: Bundle?, p2: String?, p3: ContentProviderClient?, p4: SyncResult?) {

    }

    companion object {
        private val SYNC_INTERVAL: Long = 60  // 60 seconds
        private val SYNC_FLEXTIME: Long = SYNC_INTERVAL / 3

        fun initializeSyncAdapter(context: Context){
            getSyncAccount(context)
        }

        private fun getSyncAccount(context: Context): Account? {
            val accountManager = context.getSystemService(Context.ACCOUNT_SERVICE) as AccountManager
            val newAccount = Account(context.getString(R.string.app_name), context.getString(R.string.account_type))
            if(null == accountManager.getPassword(newAccount)){
                if(!accountManager.addAccountExplicitly(newAccount,"", null)){
                    return null
                }
                onAccountCreated(newAccount, context)
            }
            return newAccount
        }

        private fun onAccountCreated(newAccount: Account, context: Context) {
            WeatherSyncAdapter.configurePeriodicSync(context, SYNC_INTERVAL, SYNC_FLEXTIME)
            ContentResolver.setSyncAutomatically(newAccount, context.getString(R.string.authority), true)
            syncImmediately(context)
        }

        private fun configurePeriodicSync(context: Context, synC_INTERVAL: Long, synC_FLEXTIME: Long) {
            val account = getSyncAccount(context)
            val authority = context.getString(R.string.authority)
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
                val request = SyncRequest.Builder()
                        .syncPeriodic(synC_INTERVAL, synC_FLEXTIME)
                        .setSyncAdapter(account, authority)
                        .setExtras(Bundle())
                        .build()
                ContentResolver.requestSync(request)
            }else{
                ContentResolver.addPeriodicSync(account, authority, Bundle.EMPTY, synC_INTERVAL)
            }
        }

        private fun syncImmediately(context: Context) {
            val bundle = Bundle()
            bundle.putBoolean(ContentResolver.SYNC_EXTRAS_EXPEDITED, true)
            bundle.putBoolean(ContentResolver.SYNC_EXTRAS_MANUAL, true)
            ContentResolver.requestSync(getSyncAccount(context), context.getString(R.string.authority), bundle)
        }
    }
}