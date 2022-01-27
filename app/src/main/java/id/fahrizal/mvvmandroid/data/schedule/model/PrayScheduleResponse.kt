package id.fahrizal.mvvmandroid.data.schedule.model

class PrayScheduleResponse(
    val code: Int? = null,
    val results: Results? = null,
    val status: String? = null
) {

    class Location(
        val elevation: Double? = null,
        val country: String? = null,
        val countryCode: String? = null,
        val localOffset: Double? = null,
        val city: String? = null,
        val timezone: String? = null,
        val latitude: Double? = null,
        val longitude: Double? = null
    )

    class Date(
        val hijri: String? = null,
        val gregorian: String? = null,
        val timestamp: Long = 0
    )

    class Results(
        val settings: Settings? = null,
        val datetime: List<DatetimeItem?>? = null,
        val location: Location? = null
    )

    class Settings(
        val school: String? = null,
        val juristic: String? = null,
        val timeformat: String? = null,
        val highlat: String? = null,
        val fajrAngle: Double? = null,
        val ishaAngle: Double? = null
    )

    class Times(
        val Sunset: String = "",
        val Asr: String = "",
        val Isha: String = "",
        val Fajr: String = "",
        val Dhuhr: String = "",
        val Maghrib: String = "",
        val Sunrise: String = "",
        val Midnight: String = "",
        val Imsak: String = ""
    )

    class DatetimeItem(
        val date: Date? = null,
        val times: Times? = null
    )
}