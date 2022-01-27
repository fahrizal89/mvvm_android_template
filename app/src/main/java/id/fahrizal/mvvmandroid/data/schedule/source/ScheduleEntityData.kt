package id.fahrizal.mvvmandroid.data.schedule.source

import id.fahrizal.mvvmandroid.domain.schedule.model.PrayScheduleRequest
import id.fahrizal.mvvmandroid.domain.schedule.model.PraySchedule
import io.reactivex.Single

/**
 * @author Fahrizal Sentosa (fahrizal.sentosa@dana.id)
 * @version ScheduleEntityData, v 0.1 27/01/22 00.27 by Fahrizal Sentosa
 */
interface ScheduleEntityData {

    fun getPraySchedule(prayScheduleRequest: PrayScheduleRequest): Single<List<PraySchedule>>
}