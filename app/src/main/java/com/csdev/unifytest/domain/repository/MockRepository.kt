package com.csdev.unifytest.domain.repository

import com.csdev.unifytest.data.remote.mock.dto.MockResponse
import kotlinx.coroutines.flow.Flow

interface MockRepository {

    suspend fun getMockData(): Flow<MockResponse>

}