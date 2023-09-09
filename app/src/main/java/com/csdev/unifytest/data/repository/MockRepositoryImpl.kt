package com.csdev.unifytest.data.repository

import com.csdev.unifytest.data.remote.mock.MockRemoteApi
import com.csdev.unifytest.data.remote.mock.dto.MockResponse
import com.csdev.unifytest.domain.repository.MockRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MockRepositoryImpl @Inject constructor(
    private val api: MockRemoteApi
) : MockRepository {

    override suspend fun getMockData(): Flow<MockResponse> {
        return api.getMockData()
    }

}