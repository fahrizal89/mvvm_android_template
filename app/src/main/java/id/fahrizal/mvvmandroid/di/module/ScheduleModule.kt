package id.fahrizal.mvvmandroid.di.module

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import id.fahrizal.mvvmandroid.data.schedule.repository.ScheduleRepositoryImpl
import id.fahrizal.mvvmandroid.domain.schedule.repository.ScheduleRepository

/**
 * @author Fahrizal Sentosa (fahrizal.sentosa@dana.id)
 * @version ScheduleModule, v 0.1 24/01/22 23.52 by Fahrizal Sentosa
 */
@Module
@InstallIn(ViewModelComponent::class)
abstract class ScheduleModule {

    @Binds
    abstract fun bindScheduleRepository(scheduleRepositoryImpl: ScheduleRepositoryImpl): ScheduleRepository
}