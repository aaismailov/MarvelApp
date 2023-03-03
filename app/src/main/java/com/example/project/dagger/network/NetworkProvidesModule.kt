package com.example.project.dagger.network

import com.example.coreDi.scope.AppScope
import com.example.coreNetwork.ApiService
import com.example.coreNetwork.provider.OkHttpClientProvider
import com.example.coreNetwork.provider.RetrofitProvider
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit

@Module
class NetworkProvidesModule {

    @Provides
    fun provideOkHttpClient(): OkHttpClient = OkHttpClientProvider.get()

    @AppScope
    @Provides
    fun provideRetrofit(httpClient: OkHttpClient): Retrofit =
        RetrofitProvider.get(httpClient)

    @AppScope
    @Provides
    fun provideMarvelApi(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)
}