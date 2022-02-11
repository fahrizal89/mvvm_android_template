package id.fahrizal.mvvmandroid.presentation.home

import android.annotation.SuppressLint
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
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

@SuppressLint("StaticFieldLeak")
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPraySchedules: GetPraySchedules,
    private val coroutineDispatcherProvider: CoroutineDispatcherProvider,
    @ApplicationContext private val context: Context
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
                _uiState.value = PrayUiState.Error(ExceptionParser.getMessage(context, error))
            }
        }
    }

    private fun getTodayDate() = TimeUtil.getDateFormatted(Date())

    sealed class PrayUiState {
        object Empty : PrayUiState()
        object Loading : PrayUiState()
        class Loaded(val itemState: HomeItemUiState) : PrayUiState()
        class Error(val message: String) : PrayUiState()
    }
}