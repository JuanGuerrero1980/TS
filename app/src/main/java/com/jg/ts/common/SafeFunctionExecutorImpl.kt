package com.jg.ts.common

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

class SafeFunctionExecutorImpl: SafeFunctionExecutor {

    private val tag = SafeFunctionExecutor::class.java.simpleName

    override suspend fun <T> executeSafeFunction(function: suspend () -> T): TsResult<T> {
        return try {
            withContext(Dispatchers.IO) {
                TsResult.Success(function())
            }
        } catch(throwable: Throwable) {
            Timber.e(tag, throwable.message.toString())
            TsResult.Error(ErrorEntity(throwable.message.toString()))
        }
    }

    override suspend fun <T> executeSafeFunctionWithFallback(
        fallback: T?,
        function: suspend () -> T
    ): TsResult<T> {
        return try {
            withContext(Dispatchers.IO) {
                TsResult.Success(function())
            }
        } catch (throwable: Throwable) {
            fallback?.let { TsResult.Success(it) }
                ?: TsResult.Error(ErrorEntity(throwable.message.toString()))
        }
    }
}