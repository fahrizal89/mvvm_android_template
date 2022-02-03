package id.fahrizal.mvvmandroid.data.schedule.repository

import id.fahrizal.mvvmandroid.data.schedule.factory.ScheduleFactory
import id.fahrizal.mvvmandroid.domain.schedule.model.PraySchedule
import id.fahrizal.mvvmandroid.domain.schedule.model.PrayScheduleRequest
import id.fahrizal.mvvmandroid.domain.schedule.repository.ScheduleRepository
import id.fahrizal.mvvmandroid.util.Source
import javax.inject.Inject

class ScheduleRepositoryImpl @Inject constructor(
    private val scheduleFactory: ScheduleFactory
) : ScheduleRepository {

    override suspend fun getPrayScheduleFromNetwork(prayScheduleRequest: PrayScheduleRequest): List<PraySchedule> {
        return scheduleFactory.create(Source.NETWORK).getPraySchedule(prayScheduleRequest)
    }

    override suspend fun getPrayScheduleFromLocal(prayScheduleRequest: PrayScheduleRequest): List<PraySchedule> {
        return scheduleFactory.create(Source.LOCAL).getPraySchedule(prayScheduleRequest)
    }

    override suspend fun addPraySchedules(praySchedules: List<PraySchedule>) {
        scheduleFactory.create(Source.LOCAL).addPraySchedules(praySchedules)
    }
}