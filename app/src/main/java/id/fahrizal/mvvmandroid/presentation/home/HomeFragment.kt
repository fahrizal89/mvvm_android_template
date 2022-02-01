package id.fahrizal.mvvmandroid.presentation.home

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.viewbinding.ViewBinding
import dagger.hilt.android.AndroidEntryPoint
import id.fahrizal.mvvmandroid.databinding.FragmentHomeBinding
import id.fahrizal.mvvmandroid.presentation.base.BaseFragment
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val homeViewModel: HomeViewModel by viewModels()

    override fun constructViewBinding(): ViewBinding = FragmentHomeBinding.inflate(layoutInflater)

    override fun init(viewBinding: ViewBinding) {
        homeViewModel.getPraySchedule()
        fetchPray()
    }

    private fun fetchPray() {
        lifecycleScope.launch {
            // repeatOnLifecycle launches the block in a new coroutine every time the
            // lifecycle is in the STARTED state (or above) and cancels it when it's STOPPED.
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                homeViewModel.uiState.collect {
                    when (it) {
                        is HomeViewModel.PrayUiState.Loaded -> onLoaded()
                        else -> showLoading()
                    }
                }
            }
        }
    }

    private fun onLoaded() {
        Timber.d("onLoaded")
    }

    private fun showLoading() {
        Timber.d("showLoading")
    }
}