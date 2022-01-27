package id.fahrizal.mvvmandroid.domain.schedule.usecase

import id.fahrizal.mvvmandroid.domain.base.UseCase
import id.fahrizal.mvvmandroid.domain.schedule.model.PraySchedule
import id.fahrizal.mvvmandroid.domain.schedule.model.PrayScheduleRequest
import id.fahrizal.mvvmandroid.domain.schedule.repository.ScheduleRepository
import io.reactivex.Single
import javax.inject.Inject

class GetPraySchedules @Inject constructor(
    private val scheduleRepository: ScheduleRepository
) : UseCase<PrayScheduleRequest, Single<List<PraySchedule>>> {

    override fun execute(param: PrayScheduleRequest): Single<List<PraySchedule>> {
        return scheduleRepository.getPrayScheduleFromNetwork(param)
    }
}