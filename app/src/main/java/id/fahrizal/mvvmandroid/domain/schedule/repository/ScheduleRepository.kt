package id.fahrizal.mvvmandroid.domain.schedule.repository

import id.fahrizal.mvvmandroid.domain.schedule.model.PraySchedule
import id.fahrizal.mvvmandroid.domain.schedule.model.PrayScheduleRequest

interface ScheduleRepository {

    suspend fun getPraySchedules(prayScheduleRequest: PrayScheduleRequest): List<PraySchedule>
}