package annasblackhat.com.daggerarchcomponentsyncadapter.data.remote.model


import com.google.gson.annotations.SerializedName

data class Condition(

	@field:SerializedName("code")
	var code: Int? = null,

	@field:SerializedName("icon")
	var icon: String? = null,

	@field:SerializedName("text")
	var text: String? = null
)