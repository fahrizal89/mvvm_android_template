package id.fahrizal.mvvmandroid.data.schedule.source.network

import id.fahrizal.mvvmandroid.data.schedule.api.PrayApi
import id.fahrizal.mvvmandroid.data.schedule.mapper.PrayScheduleResponseMapper.toPraySchedules
import id.fahrizal.mvvmandroid.domain.schedule.model.PrayScheduleRequest
import id.fahrizal.mvvmandroid.data.schedule.source.ScheduleEntityData
import id.fahrizal.mvvmandroid.domain.schedule.model.PraySchedule
import io.reactivex.Single
import javax.inject.Inject

/**
 * @author Fahrizal Sentosa (fahrizal.sentosa@dana.id)
 * @version NetworkScheduleEntityData, v 0.1 27/01/22 00.28 by Fahrizal Sentosa
 */
class NetworkScheduleEntityData @Inject constructor(
    private val prayApi: PrayApi
) : ScheduleEntityData {

    override fun getPraySchedule(prayScheduleRequest: PrayScheduleRequest): Single<List<PraySchedule>> {
        return prayApi.getPraySchedule(prayScheduleRequest.city, prayScheduleRequest.date)
            .map { it.toPraySchedules() }
    }
}