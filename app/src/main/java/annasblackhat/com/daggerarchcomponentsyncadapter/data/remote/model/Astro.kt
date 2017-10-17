package annasblackhat.com.daggerarchcomponentsyncadapter.data.remote.model

import com.google.gson.annotations.SerializedName

data class Astro(

	@field:SerializedName("moonset")
	var moonset: String? = null,

	@field:SerializedName("sunrise")
	var sunrise: String? = null,

	@field:SerializedName("sunset")
	var sunset: String? = null,

	@field:SerializedName("moonrise")
	var moonrise: String? = null
)