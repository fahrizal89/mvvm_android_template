package id.fahrizal.mvvmandroid.presentation.home

import id.fahrizal.mvvmandroid.domain.schedule.model.PraySchedule

data class HomeItemUiState(
    val city: String,
    val schedules: List<PraySchedule>
)