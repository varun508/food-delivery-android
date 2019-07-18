package com.trihkfoods.main.data.network.service

import com.trihkfoods.main.data.network.response.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface AuthService {

    @GET("/auth-check")
    suspend fun checkUserExistence(@Query("phone") phone: String): ApiResponse<Void>
}