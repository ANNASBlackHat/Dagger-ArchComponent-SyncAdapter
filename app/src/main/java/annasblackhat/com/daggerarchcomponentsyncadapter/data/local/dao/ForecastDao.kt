package annasblackhat.com.daggerarchcomponentsyncadapter.data.local.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import annasblackhat.com.daggerarchcomponentsyncadapter.data.local.entity.ForecastEntity

/**
 * Created by Annas BlackHat on 17/10/2017.
 */

@Dao
interface ForecastDao {
    @Query("SELECT * FROM forecast WHERE dateEpoch >= :currentTime")
    fun getForecast(currentTime: Int): LiveData<List<ForecastEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveForecast(forecastEntity: List<ForecastEntity>)
}