package id.fahrizal.mvvmandroid.domain.schedule.repository

import id.fahrizal.mvvmandroid.domain.schedule.model.PraySchedule
import id.fahrizal.mvvmandroid.domain.schedule.model.PrayScheduleRequest
import io.reactivex.Single

interface ScheduleRepository {

    fun getPrayScheduleFromNetwork(prayScheduleRequest: PrayScheduleRequest): Single<List<PraySchedule>>

    fun getPrayScheduleFromLocal(prayScheduleRequest: PrayScheduleRequest): Single<List<PraySchedule>>
}