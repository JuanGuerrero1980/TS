package com.jg.ts.common

interface SafeFunctionExecutor {

    suspend fun <T> executeSafeFunction(function: suspend () -> T) : TsResult<T>

    suspend fun <T> executeSafeFunctionWithFallback(
        fallback: T?,
        function: suspend () -> T
    ) : TsResult<T>
}