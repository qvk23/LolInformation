package com.test.lolinformation.data.remote.response

open class BaseListResponse<Item>(
    val total: Int? = null,
    val page: Int? = null,
    val results: List<Item>? = null
)
