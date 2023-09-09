package com.csdev.unifytest.data.remote.mock

import com.csdev.unifytest.data.remote.mock.dto.MockResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface MockRemoteApi {

    @GET("/v1/mock")
    suspend fun getMockData(): Flow<MockResponse>

}