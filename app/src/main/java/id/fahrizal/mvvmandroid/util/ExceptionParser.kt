package id.fahrizal.mvvmandroid.util

import android.content.Context
import id.fahrizal.mvvmandroid.R
import retrofit2.HttpException

object ExceptionParser {

    fun getMessage(context: Context, exception: Exception): String {
        return when (exception) {
            is HttpException -> getHttpErrorMessage(context, exception)
            else -> generalError(context)
        }
    }

    private fun getHttpErrorMessage(context: Context, exception: HttpException): String {
        return when (exception.code()) {
            404 -> context.getString(R.string.error_not_found)
            else -> generalError(context)
        }
    }

    private fun generalError(context: Context) =
        context.getString(R.string.error_something_went_wrong)
}