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

    override suspend fun getPraySchedules(prayScheduleRequest: PrayScheduleRequest): List<PraySchedule> {
        return scheduleFactory.create(Source.LOCAL).getPraySchedule(prayScheduleRequest)
            .ifEmpty {
                return scheduleFactory.create(Source.NETWORK).getPraySchedule(prayScheduleRequest)
                    .also { scheduleFactory.create(Source.LOCAL)::addPraySchedules }
            }
    }
}