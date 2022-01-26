package id.fahrizal.mvvmandroid.data.schedule.source.local

import id.fahrizal.mvvmandroid.data.schedule.source.ScheduleEntityData
import id.fahrizal.mvvmandroid.domain.schedule.model.PraySchedule
import io.reactivex.Single
import javax.inject.Inject

/**
 * @author Fahrizal Sentosa (fahrizal.sentosa@dana.id)
 * @version LocalScheduleEntityData, v 0.1 27/01/22 00.29 by Fahrizal Sentosa
 */
class LocalScheduleEntityData @Inject constructor() : ScheduleEntityData {

    override fun getPraySchedule(): Single<List<PraySchedule>> {
        return Single.just(ArrayList())
    }
}