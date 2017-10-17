package annasblackhat.com.daggerarchcomponentsyncadapter.data.remote.model


import annasblackhat.com.daggerarchcomponentsyncadapter.data.local.entity.ForecastEntity
import com.google.gson.annotations.SerializedName

data class Forecast(

	@field:SerializedName("forecastday")
	val forecastday: List<ForecastEntity>? = null
)