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
import id.fahrizal.mvvmandroid.domain.schedule.model.PraySchedule
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
        fetchPray()
    }

    private fun initUi() {
        getViewBinding().prayScheduleRv.run {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = prayAdapter
        }
    }

    private fun fetchPray() {
        lifecycleScope.launch {
            // repeatOnLifecycle launches the block in a new coroutine every time the
            // lifecycle is in the STARTED state (or above) and cancels it when it's STOPPED.
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                homeViewModel.uiState.collect {
                    when (it) {
                        is HomeViewModel.PrayUiState.Loaded -> onLoaded(it.data)
                        is HomeViewModel.PrayUiState.Error -> showError(it.message)
                        else -> showLoading()
                    }
                }
            }
        }
    }

    private fun onLoaded(praySchedules: List<PraySchedule>) {
        prayAdapter.update(praySchedules)
    }

    private fun showLoading() {
        Timber.d("showLoading")
    }

    private fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}