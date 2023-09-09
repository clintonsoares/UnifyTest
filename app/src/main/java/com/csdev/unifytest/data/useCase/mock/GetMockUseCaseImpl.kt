package com.csdev.unifytest.data.useCase.mock

import com.csdev.unifytest.domain.repository.MockRepository
import com.csdev.unifytest.domain.useCase.mock.GetMockUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetMockUseCaseImpl @Inject constructor(
    private val repository: MockRepository
): GetMockUseCase {

    override suspend fun getMockData(): Flow<String> {
        return repository.getMockData().map {
            it.data
        }
    }

}