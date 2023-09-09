package com.csdev.unifytest.di

import com.csdev.unifytest.data.remote.mock.MockRemoteApi
import com.csdev.unifytest.data.repository.MockRepositoryImpl
import com.csdev.unifytest.data.useCase.mock.GetMockUseCaseImpl
import com.csdev.unifytest.domain.repository.MockRepository
import com.csdev.unifytest.domain.useCase.mock.GetMockUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Copyright 2008 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * Copyright 2013 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMockRemoteApi(): MockRemoteApi {
        return Retrofit.Builder()
            .baseUrl("https://www.mock-baseurl.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MockRemoteApi::class.java)
    }

    @Provides
    @Singleton
    fun provideMockRepository(api: MockRemoteApi): MockRepository {
        return MockRepositoryImpl(api)
    }

    @Provides
    fun provideGetMockUseCase(repository: MockRepository): GetMockUseCase {
        return GetMockUseCaseImpl(repository)
    }

}