package id.fahrizal.mvvmandroid.util

import id.fahrizal.mvvmandroid.R
import retrofit2.HttpException

object ExceptionParser {

    fun getMessage(exception: Exception): Int {
        return when (exception) {
            is HttpException -> getHttpErrorMessage(exception)
            else -> generalError()
        }
    }

    private fun getHttpErrorMessage(exception: HttpException): Int {
        return when (exception.code()) {
            404 -> R.string.error_not_found
            else -> generalError()
        }
    }

    private fun generalError() = R.string.error_something_went_wrong
}