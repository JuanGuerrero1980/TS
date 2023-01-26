package com.jg.ts.di

import com.jg.ts.common.SafeFunctionExecutor
import com.jg.ts.common.SafeFunctionExecutorImpl
import com.jg.ts.data.TsRepository
import com.jg.ts.data.TsRepositoryImpl
import com.jg.ts.data.local.LocalDataSource
import com.jg.ts.data.remote.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CommonModule {

    @Singleton
    @Provides
    fun provideSafeFunctionExecutor(): SafeFunctionExecutor {
        return SafeFunctionExecutorImpl()
    }

    @Provides
    fun provideRepository(remoteDataSource: RemoteDataSource, localDataSource: LocalDataSource) : TsRepository {
        return TsRepositoryImpl(remoteDataSource, localDataSource)
    }
}