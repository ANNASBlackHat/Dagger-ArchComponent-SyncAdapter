package annasblackhat.com.daggerarchcomponentsyncadapter.data.remote.service

import annasblackhat.com.daggerarchcomponentsyncadapter.data.remote.model.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Git Solution on 17/10/2017.
 */
interface WeatherService {

    @GET("v1/forecast.json")
    fun getWeather(@Query("q")city: String = "yogyakarta",
                   @Query("days")days: Int = 7,
                   @Query("key")apiKey: String) : Call<WeatherResponse>

}