package com.trihkfoods.main.data.network.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class AccessTokenInterceptor(private val token: String) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
        val request = builder.addHeader("Authorization", "Bearer $token").build()
        return chain.proceed(request)
    }
}