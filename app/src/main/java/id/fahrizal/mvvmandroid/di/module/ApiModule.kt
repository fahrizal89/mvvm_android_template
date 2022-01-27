package id.fahrizal.mvvmandroid.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.fahrizal.mvvmandroid.data.schedule.api.PrayApi
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    fun providePrayApi(retrofit: Retrofit): PrayApi = retrofit.create(PrayApi::class.java)

}