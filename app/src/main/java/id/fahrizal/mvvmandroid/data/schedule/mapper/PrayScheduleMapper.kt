package id.fahrizal.mvvmandroid.data.schedule.mapper

import id.fahrizal.mvvmandroid.data.database.pray.model.PrayEntity
import id.fahrizal.mvvmandroid.domain.schedule.model.PraySchedule

object PrayScheduleMapper {

    fun List<PraySchedule>.toPrayEntities(): List<PrayEntity> {
        val prayEntities = ArrayList<PrayEntity>()

        forEach {
            prayEntities.add(PrayEntity(it.id, it.city, it.name, it.time))
        }
        return prayEntities
    }
}