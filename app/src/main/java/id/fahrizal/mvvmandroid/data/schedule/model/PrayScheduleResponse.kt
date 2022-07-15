package id.fahrizal.mvvmandroid.data.schedule.model

class PrayScheduleResponse(
    val country: String? = null,
    val statusDescription: String? = null,
    val address: String? = null,
    val statusCode: Int? = null,
    val method: Int? = null,
    val prayerMethodName: String? = null,
    val city: String? = null,
    val timezone: String? = null,
    val query: String? = null,
    val latitude: String? = null,
    val jsonMemberFor: String? = null,
    val link: String? = null,
    val qiblaDirection: String? = null,
    val title: String? = null,
    val statusValid: Int? = null,
    val sealevel: String? = null,
    val countryCode: String? = null,
    val daylight: Int? = null,
    val todayWeather: TodayWeather? = null,
    val state: String? = null,
    val postalCode: String? = null,
    val items: List<ItemsItem?>? = null,
    val mapImage: String? = null,
    val longitude: String? = null
)

data class ItemsItem(
    val asr: String? = null,
    val isha: String? = null,
    val shurooq: String? = null,
    val date_for: String? = null,
    val dhuhr: String? = null,
    val fajr: String? = null,
    val maghrib: String? = null
)

data class TodayWeather(
    val temperature: String? = null,
    val pressure: String? = null
)