package id.fahrizal.mvvmandroid.data.schedule.mapper

import id.fahrizal.mvvmandroid.data.schedule.model.PrayScheduleResponse
import id.fahrizal.mvvmandroid.domain.schedule.model.PraySchedule
import id.fahrizal.mvvmandroid.util.TimeUtil

object PrayScheduleResponseMapper {

    fun PrayScheduleResponse.toPraySchedules(): List<PraySchedule> {
        val praySchedules = ArrayList<PraySchedule>()
        val city = results?.location?.city ?: ""
        results?.datetime?.forEach {
            val dayStr = it?.date?.gregorian ?: "2000-01-01"

            it?.times?.let { times ->
                praySchedules
                    .add(PraySchedule(city, "Fajr", TimeUtil.setTime(dayStr, times.Fajr)))
                praySchedules
                    .add(PraySchedule(city, "Dhuhr", TimeUtil.setTime(dayStr, times.Dhuhr)))
                praySchedules
                    .add(PraySchedule(city, "Asr", TimeUtil.setTime(dayStr, times.Asr)))
                praySchedules
                    .add(PraySchedule(city, "Maghrib", TimeUtil.setTime(dayStr, times.Maghrib)))
                praySchedules
                    .add(PraySchedule(city, "Isha", TimeUtil.setTime(dayStr, times.Isha)))
            }
        }

        return praySchedules
    }
}