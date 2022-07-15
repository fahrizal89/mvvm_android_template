package id.fahrizal.mvvmandroid.domain.schedule.usecase

import id.fahrizal.mvvmandroid.domain.schedule.model.PraySchedule
import id.fahrizal.mvvmandroid.domain.schedule.model.PrayScheduleRequest
import id.fahrizal.mvvmandroid.domain.schedule.repository.ScheduleRepository
import javax.inject.Inject

class GetPraySchedules @Inject constructor(
    private val scheduleRepository: ScheduleRepository
) {

    suspend fun execute(request: PrayScheduleRequest): List<PraySchedule> {
        return getPrayScheduleFromLocal(request).ifEmpty {
            val praySchedules = getPraySchedulesFromNetwork(request)

            scheduleRepository.addPraySchedules(praySchedules)
            getPrayScheduleFromLocal(request)
        }
    }

    private suspend fun getPrayScheduleFromLocal(param: PrayScheduleRequest): List<PraySchedule> {
        return scheduleRepository.getPrayScheduleFromLocal(param)
    }

    private suspend fun getPraySchedulesFromNetwork(param: PrayScheduleRequest): List<PraySchedule> {
        return scheduleRepository.getPrayScheduleFromNetwork(param)
    }
}