package annasblackhat.com.daggerarchcomponentsyncadapter.data.remote.model


import com.google.gson.annotations.SerializedName

data class WeatherResponse(

	@field:SerializedName("location")
	val location: Location? = null,

	@field:SerializedName("forecast")
	val forecast: Forecast? = null
)