package com.csdev.unifytest.data.remote.mock.dto

import com.google.gson.annotations.SerializedName

data class MockResponse(
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("data")
    val data: String
)

