package com.trihkfoods.main.data.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

object ServiceGenerator {

    private const val BASE_URL = "http://localhost:3000/v1"
    private const val CONNECT_TIMEOUT = 30L
    private const val READ_TIMEOUT = 20L
    private const val WRITE_TIMEOUT = 20L

    private val client = OkHttpClient.Builder()
        .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
        .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
        .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
        .retryOnConnectionFailure(false)


    private val retrofitBuilder = Retrofit.Builder()
        .baseUrl(BASE_URL)

    private val retrofit = retrofitBuilder.build()

    private val httpLoggingInterceptor: HttpLoggingInterceptor by lazy {
        HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BASIC)
    }

    fun <T> createService(serviceClass: Class<T>): T {

    }

    fun <T> createService(serviceClass: Class<T>, token: String?): T {

        token?.run {

        }
        return retrofit.create(serviceClass)
    }


    fun addBasicInterceptors() {
        if (!client.interceptors().contains(httpLoggingInterceptor)) {
            client.addInterceptor(httpLoggingInterceptor)
        }
    }
}
