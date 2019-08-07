package com.trihkfoods.main.network.service

import com.trihkfoods.main.network.response.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface AuthService {

    @GET("/auth-check")
    suspend fun checkUserExistence(@Query("phone") phone: String): ApiResponse<Void>
}