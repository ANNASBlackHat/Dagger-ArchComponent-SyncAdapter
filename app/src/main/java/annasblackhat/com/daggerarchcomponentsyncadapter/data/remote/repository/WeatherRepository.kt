package annasblackhat.com.daggerarchcomponentsyncadapter.data.remote.repository

import android.arch.lifecycle.LiveData
import annasblackhat.com.daggerarchcomponentsyncadapter.data.local.dao.ForecastDao
import annasblackhat.com.daggerarchcomponentsyncadapter.data.local.entity.ForecastEntity
import annasblackhat.com.daggerarchcomponentsyncadapter.data.remote.model.WeatherResponse
import annasblackhat.com.daggerarchcomponentsyncadapter.data.remote.service.WeatherService
import id.uniq.uniqpos.data.remote.NetworkBoundResource
import id.uniq.uniqpos.data.remote.Resource
import javax.inject.Inject

/**
 * Created by Git Solution on 17/10/2017.
 */
class WeatherRepository @Inject
constructor(private val forecastDao: ForecastDao, private val weatherService: WeatherService){

    fun loadForecast(apikey: String, currentDate: Int): LiveData<Resource<List<ForecastEntity>>>{
        return object : NetworkBoundResource<List<ForecastEntity>, WeatherResponse>(){
            override fun saveCallResult(item: WeatherResponse?) {
                item?.forecast?.forecastday?.apply { forecastDao.saveForecast(item.forecast.forecastday) }
            }

            override fun loadFromDb() = forecastDao.getForecast(currentDate)

            override fun createCall() = weatherService.getWeather(apiKey = apikey)
        }.asLiveData
    }
}