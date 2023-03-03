package com.example.coreNetwork.provider

import com.example.core.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

object OkHttpClientProvider {
    fun get(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)
        httpClient.addInterceptor { chain ->
            val original = chain.request()
            val originalHttpUrl = original.url

            val url = originalHttpUrl.newBuilder()
                .addQueryParameter(Constants.HttpKeys.API_KEY, Constants.PUBLIC_KEY)
                .addQueryParameter(Constants.HttpKeys.TIMESTAMP, Constants.timeStamp)
                .addQueryParameter(Constants.HttpKeys.HASH_KEY, Constants.hash())
                .build()

            chain.proceed(original.newBuilder().url(url).build())
        }
        return httpClient.build()
    }
}