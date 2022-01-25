package id.fahrizal.mvvmandroid.data.schedule.repository

import id.fahrizal.mvvmandroid.domain.schedule.model.PraySchedule
import id.fahrizal.mvvmandroid.domain.schedule.repository.ScheduleRepository
import io.reactivex.Single
import javax.inject.Inject

/**
 * @author Fahrizal Sentosa (fahrizal.sentosa@dana.id)
 * @version ScheduleRepositoryImpl, v 0.1 24/01/22 23.59 by Fahrizal Sentosa
 */
class ScheduleRepositoryImpl @Inject constructor() : ScheduleRepository {

    override fun getPraySchedule(): Single<List<PraySchedule>> {
        return Single.just(ArrayList())
    }
}