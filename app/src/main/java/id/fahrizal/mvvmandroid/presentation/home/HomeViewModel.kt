package id.fahrizal.mvvmandroid.presentation.home

import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.fahrizal.mvvmandroid.data.networking.CoroutineDispatcherProvider
import id.fahrizal.mvvmandroid.domain.schedule.model.PrayScheduleRequest
import id.fahrizal.mvvmandroid.domain.schedule.usecase.GetPraySchedules
import id.fahrizal.mvvmandroid.util.ExceptionParser
import id.fahrizal.mvvmandroid.util.TimeUtil
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPraySchedules: GetPraySchedules,
    private val coroutineDispatcherProvider: CoroutineDispatcherProvider
) : ViewModel() {

    private val _uiState = MutableStateFlow<PrayUiState>(PrayUiState.Empty)
    val uiState: StateFlow<PrayUiState> = _uiState

    fun getPraySchedule() {
        _uiState.value = PrayUiState.Loading

        viewModelScope.launch(coroutineDispatcherProvider.IO()) {
            try {
                val city = "Jakarta"
                val requestParam = PrayScheduleRequest(city, getTodayDate())
                val result = getPraySchedules.execute(requestParam)

                _uiState.value = PrayUiState.Loaded(HomeItemUiState(city, result))
            } catch (error: Exception) {
                _uiState.value = PrayUiState.Error(ExceptionParser.getMessage(error))
            }
        }
    }

    private fun getTodayDate() = TimeUtil.getDateFormatted(Date())

    sealed class PrayUiState {
        object Empty : PrayUiState()
        object Loading : PrayUiState()
        class Loaded(val itemState: HomeItemUiState) : PrayUiState()
        class Error(@StringRes val message: Int) : PrayUiState()
    }
}