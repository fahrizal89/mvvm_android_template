package id.fahrizal.mvvmandroid.data.schedule.mapper

import id.fahrizal.mvvmandroid.data.schedule.model.PrayScheduleResponse
import id.fahrizal.mvvmandroid.domain.schedule.model.PraySchedule
import id.fahrizal.mvvmandroid.util.TimeUtil

object PrayScheduleResponseMapper {

    fun PrayScheduleResponse.toPraySchedules(): List<PraySchedule> {
        val praySchedules = ArrayList<PraySchedule>()
        val cityName = state ?: ""
        val format = "yyyy-M-dd hh:mm a"

        items?.get(0)?.let { dataItem ->
            val dateStr = dataItem.date_for

            praySchedules.add(
                PraySchedule(
                    cityName, "Fajr",
                    TimeUtil.getTimestamp(format, dateStr.plus(" ").plus(dataItem.fajr))
                )
            )

            praySchedules.add(
                PraySchedule(
                    cityName, "Dhuhr",
                    TimeUtil.getTimestamp(format, dateStr.plus(" ").plus(dataItem.dhuhr))
                )
            )

            praySchedules.add(
                PraySchedule(
                    cityName, "Asr",
                    TimeUtil.getTimestamp(format, dateStr.plus(" ").plus(dataItem.asr))
                )
            )

            praySchedules.add(
                PraySchedule(
                    cityName, "Maghrib",
                    TimeUtil.getTimestamp(format, dateStr.plus(" ").plus(dataItem.maghrib))
                )
            )

            praySchedules.add(
                PraySchedule(
                    cityName, "Isha",
                    TimeUtil.getTimestamp(format, dateStr.plus(" ").plus(dataItem.isha))
                )
            )

        }

        return praySchedules
    }
}