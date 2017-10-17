package annasblackhat.com.daggerarchcomponentsyncadapter.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import annasblackhat.com.daggerarchcomponentsyncadapter.data.local.dao.ForecastDao
import annasblackhat.com.daggerarchcomponentsyncadapter.data.local.entity.ForecastEntity

/**
 * Created by Annas BlackHat on 17/10/2017.
 */

@Database(entities = arrayOf(ForecastEntity::class), version = 1)
abstract class WeatherDatabase: RoomDatabase() {
    abstract fun forecastDao(): ForecastDao
}