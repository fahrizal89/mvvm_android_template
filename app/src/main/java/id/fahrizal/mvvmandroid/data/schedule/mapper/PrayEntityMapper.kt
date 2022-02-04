package id.fahrizal.mvvmandroid.data.schedule.mapper

import id.fahrizal.mvvmandroid.data.database.pray.model.PrayEntity
import id.fahrizal.mvvmandroid.domain.schedule.model.PraySchedule

object PrayEntityMapper {

    fun List<PrayEntity>.toPraySchedules(): List<PraySchedule> {
        val praySchedules = ArrayList<PraySchedule>()
        forEach {
            praySchedules.add(PraySchedule(it.city, it.name, it.time, it.id))
        }

        return praySchedules
    }
}