package id.fahrizal.mvvmandroid.data.schedule.mapper

import id.fahrizal.mvvmandroid.data.database.pray.model.PrayEntity
import id.fahrizal.mvvmandroid.domain.schedule.model.PraySchedule

/**
 * @author Fahrizal Sentosa (fahrizal.sentosa@dana.id)
 * @version PrayEntityMapper, v 0.1 03/02/22 22.46 by Fahrizal Sentosa
 */
object PrayEntityMapper {

    fun List<PrayEntity>.toPraySchedules(): List<PraySchedule> {
        return ArrayList<PraySchedule>().apply {
            forEach {
                add(PraySchedule(it.city, it.name, it.time, it.id))
            }
        }
    }
}