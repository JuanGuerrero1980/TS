package com.jg.ts.common

sealed class TsResult<T> {
    class Success<T>(val result: T) : TsResult<T>()
    class Error<T>(val error: ErrorEntity) : TsResult<T>()
}
