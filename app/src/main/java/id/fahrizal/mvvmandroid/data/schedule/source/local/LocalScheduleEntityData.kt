package id.fahrizal.mvvmandroid.data.schedule.source.local

import id.fahrizal.mvvmandroid.data.database.pray.dao.PrayDao
import id.fahrizal.mvvmandroid.data.schedule.mapper.PrayEntityMapper.toPraySchedules
import id.fahrizal.mvvmandroid.data.schedule.source.ScheduleEntityData
import id.fahrizal.mvvmandroid.domain.schedule.model.PraySchedule
import id.fahrizal.mvvmandroid.domain.schedule.model.PrayScheduleRequest
import id.fahrizal.mvvmandroid.util.TimeUtil
import javax.inject.Inject

/**
 * @author Fahrizal Sentosa (fahrizal.sentosa@dana.id)
 * @version LocalScheduleEntityData, v 0.1 27/01/22 00.29 by Fahrizal Sentosa
 */
class LocalScheduleEntityData @Inject constructor(
    private val prayDao: PrayDao
) : ScheduleEntityData {

    override suspend fun getPraySchedule(prayScheduleRequest: PrayScheduleRequest): List<PraySchedule> {
        val from = TimeUtil.getTimestamp(prayScheduleRequest.date)
        val to = TimeUtil.getTimestamp(prayScheduleRequest.date, 1)

        return prayDao.getPraySchedule(prayScheduleRequest.city, from, to).toPraySchedules()
    }
}