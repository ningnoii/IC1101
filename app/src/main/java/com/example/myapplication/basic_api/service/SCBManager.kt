package com.example.myapplication.basic_api.service

import com.example.myapplication.basic_api.Interceptor.DeeplinkTransactionHeaderInterceptor
import com.example.myapplication.basic_api.Interceptor.HeaderInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



class SCBManager {
    private lateinit var deeplinkTS: OkHttpClient

    companion object {
        const val BASE_SCB_API = "https://api.partners.scb/partners/sandbox/"
        var client = OkHttpClient.Builder().addInterceptor(HeaderInterceptor()).build();

    }

    fun createService(): SCBApiService =
        Retrofit.Builder()
            .baseUrl(BASE_SCB_API)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client).build()
            .run { create(SCBApiService::class.java) }

    fun setHeaderDeeplinkTransactionService(accessToken: String) {

        val dl: DeeplinkTransactionHeaderInterceptor = DeeplinkTransactionHeaderInterceptor();
        dl.setAccessToken(accessToken)
        deeplinkTS = OkHttpClient.Builder().addInterceptor(dl).build()
        println("ningnananoii > dl : "+ deeplinkTS)

    }
    fun createDeeplinkTransactionService(): SCBApiService = Retrofit.Builder()
        .baseUrl(BASE_SCB_API)
        .addConverterFactory(GsonConverterFactory.create())
        .client(deeplinkTS as OkHttpClient).build()
        .run { create(SCBApiService::class.java) }
}


