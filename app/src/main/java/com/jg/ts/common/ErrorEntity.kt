package com.jg.ts.common

open class ErrorEntity(override val message: String): Throwable(message) {
    sealed class TsErrorEntity(message: String) : ErrorEntity(message)
        object UnknownError : TsErrorEntity("Unknown Error!")

    data class CustomError(override val message: String) : ErrorEntity(message)
}
