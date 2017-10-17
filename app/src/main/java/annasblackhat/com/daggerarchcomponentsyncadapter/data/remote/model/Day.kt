package annasblackhat.com.daggerarchcomponentsyncadapter.data.remote.model


import android.arch.persistence.room.Embedded
import com.google.gson.annotations.SerializedName

data class Day(

	@field:SerializedName("avgvis_km")
	var avgvisKm: Double? = null,

	@field:SerializedName("uv")
	var uv: Double? = null,

	@field:SerializedName("avgtemp_f")
	var avgtempF: Double? = null,

	@field:SerializedName("avgtemp_c")
	var avgtempC: Double? = null,

	@field:SerializedName("maxtemp_c")
	var maxtempC: Double? = null,

	@field:SerializedName("maxtemp_f")
	var maxtempF: Double? = null,

	@field:SerializedName("mintemp_c")
	var mintempC: Double? = null,

	@field:SerializedName("avgvis_miles")
	var avgvisMiles: Int? = null,

	@field:SerializedName("mintemp_f")
	var mintempF: Double? = null,

	@field:SerializedName("totalprecip_in")
	var totalprecipIn: Int? = null,

	@field:SerializedName("avghumidity")
	var avghumidity: Int? = null,

	@Embedded
	@field:SerializedName("condition")
	var condition: Condition? = null,

	@field:SerializedName("maxwind_kph")
	var maxwindKph: Double? = null,

	@field:SerializedName("maxwind_mph")
	var maxwindMph: Double? = null,

	@field:SerializedName("totalprecip_mm")
	var totalprecipMm: Int? = null
)