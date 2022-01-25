package id.fahrizal.mvvmandroid.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import id.fahrizal.mvvmandroid.domain.schedule.model.PraySchedule
import id.fahrizal.mvvmandroid.domain.schedule.usecase.GetPraySchedules
import id.fahrizal.mvvmandroid.util.rx.ObservableExt.observe
import id.fahrizal.mvvmandroid.util.rx.SimpleSingleObserver
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val state: SavedStateHandle,
    private val getPraySchedules: GetPraySchedules
) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    fun getPraySchedule() {
        getPraySchedules.execute().observe(object : SimpleSingleObserver<List<PraySchedule>>() {
            override fun onSuccessful(response: List<PraySchedule>) {

            }

            override fun onError(message: String) {
                //no op
            }
        })
    }
}