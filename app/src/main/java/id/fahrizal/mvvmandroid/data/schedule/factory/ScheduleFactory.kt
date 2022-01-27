package id.fahrizal.mvvmandroid.data.schedule.factory

import id.fahrizal.mvvmandroid.data.schedule.source.ScheduleEntityData
import id.fahrizal.mvvmandroid.data.schedule.source.local.LocalScheduleEntityData
import id.fahrizal.mvvmandroid.data.schedule.source.network.NetworkScheduleEntityData
import id.fahrizal.mvvmandroid.util.Source
import javax.inject.Inject

class ScheduleFactory @Inject constructor(
    private val networkScheduleEntityData: NetworkScheduleEntityData,
    private val localScheduleEntityData: LocalScheduleEntityData
) {

    fun create(source: Source): ScheduleEntityData {
        return when (source) {
            Source.NETWORK -> networkScheduleEntityData
            else -> localScheduleEntityData
        }
    }
}