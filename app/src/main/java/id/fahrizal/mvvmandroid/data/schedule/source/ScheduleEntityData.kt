package id.fahrizal.mvvmandroid.data.schedule.source

import id.fahrizal.mvvmandroid.domain.schedule.model.PraySchedule
import id.fahrizal.mvvmandroid.domain.schedule.model.PrayScheduleRequest

interface ScheduleEntityData {

    suspend fun getPraySchedule(prayScheduleRequest: PrayScheduleRequest): List<PraySchedule>

    suspend fun addPraySchedules(praySchedules: List<PraySchedule>)
}