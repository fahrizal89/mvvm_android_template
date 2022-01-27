package id.fahrizal.mvvmandroid.data.schedule.api

import id.fahrizal.mvvmandroid.data.schedule.model.PrayScheduleResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface PrayApi {

    @GET("/v2/times/this_month.json")
    fun getPraySchedule(
        @Query("city") city: String,
        @Query("date") date: String
    ): Single<PrayScheduleResponse>
}