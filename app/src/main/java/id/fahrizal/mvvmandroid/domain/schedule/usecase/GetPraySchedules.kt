package id.fahrizal.mvvmandroid.domain.schedule.usecase

import id.fahrizal.mvvmandroid.domain.schedule.repository.ScheduleRepository
import javax.inject.Inject

/**
 * @author Fahrizal Sentosa (fahrizal.sentosa@dana.id)
 * @version GetPraySchedules, v 0.1 24/01/22 23.42 by Fahrizal Sentosa
 */
class GetPraySchedules @Inject constructor(
    private val scheduleRepository: ScheduleRepository
) {

    fun execute() {
        scheduleRepository.getPraySchedule()
    }
}