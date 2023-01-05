package com.mbs.api_recycler

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {
    val api: ApiController by lazy {
        Retrofit.Builder()
            .baseUrl("http://173.255.201.227/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiController::class.java)
    }
}