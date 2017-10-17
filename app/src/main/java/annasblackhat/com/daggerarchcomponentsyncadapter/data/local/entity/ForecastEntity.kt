package annasblackhat.com.daggerarchcomponentsyncadapter.data.local.entity

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.TypeConverters
import annasblackhat.com.daggerarchcomponentsyncadapter.data.local.DoubleConverter
import annasblackhat.com.daggerarchcomponentsyncadapter.data.remote.model.Astro
import annasblackhat.com.daggerarchcomponentsyncadapter.data.remote.model.Day
import com.google.gson.annotations.SerializedName

@Entity(tableName = "forecast")
@TypeConverters(DoubleConverter::class)
data class ForecastEntity(

		@PrimaryKey
		@field:SerializedName("date")
		var date: String = "",

		@field:SerializedName("date_epoch")
		var dateEpoch: Int? = null,

		@Embedded
		@field:SerializedName("astro")
		var astro: Astro? = null,

		@Embedded
		@field:SerializedName("day")
		var day: Day? = null

)