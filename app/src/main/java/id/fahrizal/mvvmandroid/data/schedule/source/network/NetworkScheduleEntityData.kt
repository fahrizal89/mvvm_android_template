package id.fahrizal.mvvmandroid.data.schedule.source.network

import id.fahrizal.mvvmandroid.data.schedule.api.PrayApi
import id.fahrizal.mvvmandroid.data.schedule.mapper.PrayScheduleResponseMapper.toPraySchedules
import id.fahrizal.mvvmandroid.data.schedule.source.ScheduleEntityData
import id.fahrizal.mvvmandroid.domain.schedule.model.PraySchedule
import id.fahrizal.mvvmandroid.domain.schedule.model.PrayScheduleRequest
import javax.inject.Inject

class NetworkScheduleEntityData @Inject constructor(
    private val prayApi: PrayApi
) : ScheduleEntityData {

    override suspend fun getPraySchedule(prayScheduleRequest: PrayScheduleRequest): List<PraySchedule> {
        return prayApi.getPraySchedule(prayScheduleRequest.city)
            .toPraySchedules()
    }

    override suspend fun addPraySchedules(praySchedules: List<PraySchedule>) {
        //no op
    }
}