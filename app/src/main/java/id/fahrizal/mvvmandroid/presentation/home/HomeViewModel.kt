package id.fahrizal.mvvmandroid.presentation.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import id.fahrizal.mvvmandroid.domain.schedule.model.PraySchedule
import id.fahrizal.mvvmandroid.domain.schedule.model.PrayScheduleRequest
import id.fahrizal.mvvmandroid.domain.schedule.usecase.GetPraySchedules
import id.fahrizal.mvvmandroid.util.TimeUtil
import id.fahrizal.mvvmandroid.util.rx.ObservableExt.observe
import id.fahrizal.mvvmandroid.util.rx.SimpleSingleObserver
import java.util.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPraySchedules: GetPraySchedules
) : ViewModel() {

    fun getPraySchedule() {
        val request = PrayScheduleRequest("jakarta", getTodayDate())

        getPraySchedules.execute(request)
            .observe(object : SimpleSingleObserver<List<PraySchedule>>() {
                override fun onSuccessful(response: List<PraySchedule>) {
                    response.size
                }

                override fun onError(message: String) {
                    //no op
                }
            })
    }

    private fun getTodayDate() = TimeUtil.getDateFormatted(Date())
}