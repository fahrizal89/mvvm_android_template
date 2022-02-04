package id.fahrizal.mvvmandroid.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import id.fahrizal.mvvmandroid.presentation.home.adapter.PrayAdapter

@Module
@InstallIn(FragmentComponent::class)
object HomeModule {

    @Provides
    fun providePrayAdapter(): PrayAdapter {
        return PrayAdapter()
    }
}