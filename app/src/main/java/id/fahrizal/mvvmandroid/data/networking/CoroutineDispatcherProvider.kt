package id.fahrizal.mvvmandroid.data.networking

import kotlinx.coroutines.Dispatchers

/**
 * @author Fahrizal Sentosa (fahrizal.sentosa@dana.id)
 * @version CoroutineDispatcherProvider, v 0.1 02/02/22 00.17 by Fahrizal Sentosa
 */
class CoroutineDispatcherProvider {

    fun IO() = Dispatchers.IO

    fun Default() = Dispatchers.Default

    fun Main() = Dispatchers.Main
}