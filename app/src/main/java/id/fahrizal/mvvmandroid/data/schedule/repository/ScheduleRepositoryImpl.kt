package id.fahrizal.mvvmandroid.data.schedule.repository

import id.fahrizal.mvvmandroid.data.schedule.factory.ScheduleFactory
import id.fahrizal.mvvmandroid.domain.schedule.model.PraySchedule
import id.fahrizal.mvvmandroid.domain.schedule.repository.ScheduleRepository
import id.fahrizal.mvvmandroid.util.rx.Source
import io.reactivex.Single
import javax.inject.Inject

/**
 * @author Fahrizal Sentosa (fahrizal.sentosa@dana.id)
 * @version ScheduleRepositoryImpl, v 0.1 24/01/22 23.59 by Fahrizal Sentosa
 */
class ScheduleRepositoryImpl @Inject constructor(
    private val scheduleFactory: ScheduleFactory
) : ScheduleRepository {

    override fun getPrayScheduleFromNetwork(): Single<List<PraySchedule>> {
        return scheduleFactory.create(Source.NETWORK).getPraySchedule()
    }

    override fun getPrayScheduleFromLocal(): Single<List<PraySchedule>> {
        return scheduleFactory.create(Source.LOCAL).getPraySchedule()
    }
}