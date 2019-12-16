package com.test.lolinformation.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.test.lolinformation.data.remote.api.*
import retrofit2.HttpException
import java.net.SocketTimeoutException

abstract class BaseViewModel : ViewModel() {
    private val _isLoading = MutableLiveData<Boolean>().apply { value = false }
    val isLoading : LiveData<Boolean> get() = _isLoading
    private val _errorMessage = MutableLiveData<String>()
    val errorMessage : LiveData<String> get() = _errorMessage

    open fun showError(e: Throwable) {
        _errorMessage.value = when (e) {
            is HttpException -> getErrorMessage(e.code())
            is SocketTimeoutException -> getErrorMessage(CODE_TIMEOUT)
            else -> e.toString()
        }
    }
    private fun getErrorMessage(code : Int) : String = when (code) {
        CODE_TIMEOUT -> MESSAGE_TIMEOUT
        CODE_UNAUTHORISED -> MESSAGE_UNAUTHORISED
        CODE_NOT_FOUND -> MESSAGE_NOT_FOUND
        CODE_BAD_REQUEST -> MESSAGE_BAD_REQUEST
        CODE_FORBIDDEN -> MESSAGE_FORBIDDEN
        CODE_UNPROCESSABLE_ENTITY -> MESSAGE_UNPROCESSABLE_ENTITY
        else -> MESSAGE_SOMETHING_ERROR
    }

    fun showLoading() {
        _isLoading.value = true
    }

    fun hideLoading() {
        _isLoading.value = false
    }
}
