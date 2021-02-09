package com.dean.fodiestkotlin.source

import com.dean.fodiestkotlin.common.Constanta
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitConfig {
    private val retrofitConfiguration by lazy {
        Retrofit.Builder().baseUrl(Constanta().BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
    val apiServicesClient: ApiSercvices by lazy {
        retrofitConfiguration.create(ApiSercvices::class.java)
    }
}