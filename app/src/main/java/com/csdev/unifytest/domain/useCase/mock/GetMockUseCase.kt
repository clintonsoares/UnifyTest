package com.csdev.unifytest.domain.useCase.mock

import kotlinx.coroutines.flow.Flow

interface GetMockUseCase {
    suspend fun getMockData(): Flow<String>
}