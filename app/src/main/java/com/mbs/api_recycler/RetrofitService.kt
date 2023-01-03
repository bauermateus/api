package com.mbs.api_recycler

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {

    companion object{

        private lateinit var INSTANCE: Retrofit
        private const val BASE_URL = "http://173.255.201.227/api/v1/"

        private fun getRetrofitClient(): Retrofit {
            val http = OkHttpClient.Builder()
            if (!::INSTANCE.isInitialized) {
                INSTANCE = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(http.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return INSTANCE
        }
        fun createGetService(): UserService {
            return getRetrofitClient().create(UserService::class.java)
        }
    }
}