package id.fahrizal.mvvmandroid.di.module

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import id.fahrizal.mvvmandroid.data.schedule.repository.ScheduleRepositoryImpl
import id.fahrizal.mvvmandroid.domain.schedule.repository.ScheduleRepository

@Module
@InstallIn(ViewModelComponent::class)
abstract class ScheduleModule {

    @Binds
    abstract fun bindScheduleRepository(scheduleRepositoryImpl: ScheduleRepositoryImpl): ScheduleRepository
}