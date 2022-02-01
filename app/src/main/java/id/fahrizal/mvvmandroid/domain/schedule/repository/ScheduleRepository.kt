package id.fahrizal.mvvmandroid.domain.schedule.repository

import id.fahrizal.mvvmandroid.domain.schedule.model.PraySchedule
import id.fahrizal.mvvmandroid.domain.schedule.model.PrayScheduleRequest

interface ScheduleRepository {

    suspend fun getPrayScheduleFromNetwork(prayScheduleRequest: PrayScheduleRequest): List<PraySchedule>

    suspend fun getPrayScheduleFromLocal(prayScheduleRequest: PrayScheduleRequest): List<PraySchedule>
}