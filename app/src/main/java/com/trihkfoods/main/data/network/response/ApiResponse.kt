package com.trihkfoods.main.data.network.response

import retrofit2.Response
import java.io.IOException


open class ApiResponse<T> {

    fun create(error: Throwable): ApiResponse<T> {
        var message = "Something went wrong"
        error.message?.takeIf { it.isNotEmpty() }?.let { message = it }
        return ApiErrorResponse(message)
    }

    fun create(response: Response<T>): ApiResponse<T> =
        if (response.isSuccessful) {
            val body = response.body()
            if (body == null || response.code() == 204) ApiEmptyResponse() else ApiSuccessResponse(body)
        } else {
            val message = response.errorBody()?.string() ?: "Something went wrong"
            ApiErrorResponse(message)
        }


    inner class ApiSuccessResponse<T> internal constructor(val body: T) : ApiResponse<T>()

    inner class ApiErrorResponse<T> internal constructor(val errorMessage: String) : ApiResponse<T>()


    /**
     * This class handles 204 responses
     */
    inner class ApiEmptyResponse<T> : ApiResponse<T>()
}