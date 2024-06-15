package com.example.data.api

import com.example.data.utilities.Constants.Companion.EMPTY_RESPONSE_ERROR
import com.example.data.utilities.Constants.Companion.requestIODispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import java.io.IOException


class ApiResponseHandler<T> {

    fun <T> handleApiCall(apiCall: suspend () -> Response<T>): Flow<T?> {
        return flow {
            runCatching {
                apiCall()
            }.onSuccess { result ->
                if (result.isSuccessful) {
                    val responseBody = result.body()
                    if (responseBody != null) {
                        emit(responseBody)
                    } else {
                        throw EmptyResponseException(EMPTY_RESPONSE_ERROR)
                    }
                } else {
                    val exception = asException(result)
                    throw exception
                }
            }.onFailure { error ->
                val exception = when (error) {
                    is IOException -> CoinsException.networkError(error)
                    is NullPointerException -> CoinsException.nullPointerError(error)
                    else -> CoinsException.unexpectedError(error)
                }
                throw exception
            }
        }.flowOn(requestIODispatchers)
    }

    fun asException(response: Response<*>): CoinsException {
        return when (response.code()) {
            else -> CoinsException.httpError(
                throwable = null,
                url = null,
                response = response,
                retrofit = null
            )
        }
    }
}

// Custom exception for empty response
class EmptyResponseException(message: String) : Exception(message)
