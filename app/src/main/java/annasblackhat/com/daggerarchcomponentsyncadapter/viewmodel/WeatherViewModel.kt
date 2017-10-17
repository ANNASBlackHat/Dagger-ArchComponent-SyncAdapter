package annasblackhat.com.daggerarchcomponentsyncadapter.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import annasblackhat.com.daggerarchcomponentsyncadapter.data.local.entity.ForecastEntity
import annasblackhat.com.daggerarchcomponentsyncadapter.data.remote.repository.WeatherRepository
import annasblackhat.com.daggerarchcomponentsyncadapter.util.Constant
import id.uniq.uniqpos.data.remote.Resource

/**
 * Created by Git Solution on 17/10/2017.
 */
class WeatherViewModel(private val weatherRepository: WeatherRepository)  : ViewModel(){

    fun getWeather(): LiveData<Resource<List<ForecastEntity>>> {
        val unixTime = System.currentTimeMillis()/1000L
        return weatherRepository.loadForecast(Constant.API_KEY, unixTime.toInt())
    }
}