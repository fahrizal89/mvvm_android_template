package id.fahrizal.mvvmandroid.domain.schedule.repository

import id.fahrizal.mvvmandroid.domain.schedule.model.PraySchedule
import io.reactivex.Single

/**
 * @author Fahrizal Sentosa (fahrizal.sentosa@dana.id)
 * @version ScheduleRepository, v 0.1 24/01/22 23.53 by Fahrizal Sentosa
 */
interface ScheduleRepository {

    fun getPrayScheduleFromNetwork(): Single<List<PraySchedule>>
    fun getPrayScheduleFromLocal(): Single<List<PraySchedule>>
}