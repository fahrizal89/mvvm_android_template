package id.fahrizal.mvvmandroid.presentation.home

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewbinding.ViewBinding
import dagger.hilt.android.AndroidEntryPoint
import id.fahrizal.mvvmandroid.databinding.FragmentHomeBinding
import id.fahrizal.mvvmandroid.presentation.base.BaseFragment
import id.fahrizal.mvvmandroid.presentation.home.adapter.PrayAdapter
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    @Inject
    lateinit var prayAdapter: PrayAdapter

    private val homeViewModel: HomeViewModel by viewModels()

    override fun constructViewBinding(): ViewBinding = FragmentHomeBinding.inflate(layoutInflater)

    override fun init(viewBinding: ViewBinding) {
        homeViewModel.getPraySchedule()
        initUi()
        fetchPraySchedules()
    }

    private fun initUi() {
        getViewBinding().prayScheduleRv.run {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = prayAdapter
        }
    }

    private fun fetchPraySchedules() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                homeViewModel.uiState.collect {
                    when (it) {
                        is HomeViewModel.PrayUiState.Loaded -> onLoaded(it.itemState)
                        is HomeViewModel.PrayUiState.Error -> showError(it.message)
                        else -> showLoading()
                    }
                }
            }
        }
    }

    private fun onLoaded(homeItemUiState: HomeItemUiState) {
        homeItemUiState.run {
            getViewBinding().cityTv.text = city
            prayAdapter.update(schedules)
        }
    }

    private fun showLoading() {
        Timber.d("showLoading")
    }

    private fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}