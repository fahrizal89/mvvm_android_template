package id.fahrizal.mvvmandroid

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

/**
 * @author Fahrizal Sentosa (fahrizal.sentosa@dana.id)
 * @version App, v 0.1 25/01/22 00.12 by Fahrizal Sentosa
 */
@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initLogger()
    }

    private fun initLogger() = Timber.plant(Timber.DebugTree())
}