package com.test.lolinformation.ui.base

import com.test.lolinformation.ui.utils.Status

data class BaseResponse<T>(val status: Status, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T?) = BaseResponse<T>(Status.SUCCESS, data, null)
        fun <T> error(msg: String, data: T?) = BaseResponse<T>(Status.ERROR, data, msg)
        fun <T> loading(data: T?) = BaseResponse<T>(Status.LOADING, data, null)
    }
}
