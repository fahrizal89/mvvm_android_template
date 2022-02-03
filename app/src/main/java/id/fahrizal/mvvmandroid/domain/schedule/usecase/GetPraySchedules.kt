package id.fahrizal.mvvmandroid.domain.schedule.usecase

import id.fahrizal.mvvmandroid.domain.schedule.model.PraySchedule
import id.fahrizal.mvvmandroid.domain.schedule.model.PrayScheduleRequest
import id.fahrizal.mvvmandroid.domain.schedule.repository.ScheduleRepository
import javax.inject.Inject

class GetPraySchedules @Inject constructor(
    private val scheduleRepository: ScheduleRepository
) {

    suspend fun execute(param: PrayScheduleRequest): List<PraySchedule> {
        val praySchedulesLocal = scheduleRepository.getPrayScheduleFromLocal(param)

        if (praySchedulesLocal.isNotEmpty()) {
            return praySchedulesLocal
        } else {
            return getPraySchedulesFromNetworkAndInsertToLocal(param)
        }
    }

    private suspend fun getPraySchedulesFromNetworkAndInsertToLocal(param: PrayScheduleRequest): List<PraySchedule> {
        return scheduleRepository.getPrayScheduleFromNetwork(param).also {
            scheduleRepository.addPraySchedules(it)
        }
    }
}