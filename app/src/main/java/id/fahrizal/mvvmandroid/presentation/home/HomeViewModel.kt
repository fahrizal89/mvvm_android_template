package id.fahrizal.mvvmandroid.presentation.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import id.fahrizal.mvvmandroid.domain.schedule.model.PraySchedule
import id.fahrizal.mvvmandroid.domain.schedule.model.PrayScheduleRequest
import id.fahrizal.mvvmandroid.domain.schedule.usecase.GetPraySchedules
import id.fahrizal.mvvmandroid.util.TimeUtil
import id.fahrizal.mvvmandroid.util.rx.ObservableExt.observe
import id.fahrizal.mvvmandroid.util.rx.SimpleSingleObserver
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.util.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPraySchedules: GetPraySchedules
) : ViewModel() {

    private val _uiState = MutableStateFlow<PrayUiState>(PrayUiState.Empty)
    val uiState: StateFlow<PrayUiState> = _uiState

    fun getPraySchedule() {
        val requestParam = PrayScheduleRequest("jakarta", getTodayDate())

        getPraySchedules.execute(requestParam)
            .observe(object : SimpleSingleObserver<List<PraySchedule>>() {
                override fun onSuccessful(response: List<PraySchedule>) {
                    _uiState.value = PrayUiState.Loaded(response)
                }

                override fun onError(message: String) {
                    //no op
                }
            })
    }

    private fun getTodayDate() = TimeUtil.getDateFormatted(Date())

    sealed class PrayUiState {
        object Empty : PrayUiState()
        object Loading : PrayUiState()
        class Loaded(val data: List<PraySchedule>) : PrayUiState()
        class Error(val message: String) : PrayUiState()
    }
}