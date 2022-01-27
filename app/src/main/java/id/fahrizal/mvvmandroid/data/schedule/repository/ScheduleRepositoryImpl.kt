package id.fahrizal.mvvmandroid.data.schedule.repository

import id.fahrizal.mvvmandroid.data.schedule.factory.ScheduleFactory
import id.fahrizal.mvvmandroid.domain.schedule.model.PraySchedule
import id.fahrizal.mvvmandroid.domain.schedule.model.PrayScheduleRequest
import id.fahrizal.mvvmandroid.domain.schedule.repository.ScheduleRepository
import id.fahrizal.mvvmandroid.util.Source
import io.reactivex.Single
import javax.inject.Inject

class ScheduleRepositoryImpl @Inject constructor(
    private val scheduleFactory: ScheduleFactory
) : ScheduleRepository {

    override fun getPrayScheduleFromNetwork(prayScheduleRequest: PrayScheduleRequest): Single<List<PraySchedule>> {
        return scheduleFactory.create(Source.NETWORK).getPraySchedule(prayScheduleRequest)
    }

    override fun getPrayScheduleFromLocal(prayScheduleRequest: PrayScheduleRequest): Single<List<PraySchedule>> {
        return scheduleFactory.create(Source.LOCAL).getPraySchedule(prayScheduleRequest)
    }
}