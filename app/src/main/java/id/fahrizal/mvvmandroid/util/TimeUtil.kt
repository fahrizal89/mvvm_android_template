package id.fahrizal.mvvmandroid.util

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

object TimeUtil {

    fun setTime(dateString: String, time: String): Long {
        return getTimeMilis(dateString, time)
    }

    fun Long.getTimeFormated(): String =
        SimpleDateFormat("hh:mm a", Locale.getDefault()).format(Date(this))

    fun getDateFormatted(date: Date): String =
        SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(date)

    @SuppressLint("SimpleDateFormat")
    fun getTimestamp(dateString: String, plusDay: Int): Long {
        val c = Calendar.getInstance()
        c.time = SimpleDateFormat("yyyy-MM-dd").parse(dateString) ?: Date(0)
        c.add(Calendar.DATE, plusDay)
        return c.time.time
    }

    @SuppressLint("SimpleDateFormat")
    fun getTimestamp(dateString: String): Long {
        val date = SimpleDateFormat("yyyy-MM-dd").parse(dateString) ?: Date(0)
        return date.time
    }

    @SuppressLint("SimpleDateFormat")
    private fun getTimeMilis(dayTimestamp: String, time: String): Long {
        val dateTime = dayTimestamp.plus(" ").plus(time)
        return SimpleDateFormat("yyyy-MM-dd hh:mm").parse(dateTime)?.time ?:0
    }
}