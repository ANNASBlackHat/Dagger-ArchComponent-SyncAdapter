package annasblackhat.com.daggerarchcomponentsyncadapter.data.local

import android.arch.persistence.room.TypeConverter

/**
 * Created by Git Solution on 17/10/2017.
 */
object DoubleConverter {

    @TypeConverter
    fun stringToDouble(str: String): Double = str.toDouble()

    @TypeConverter
    fun doubleToString(dbl: Double): String = dbl.toString()
}