package com.mbs.api_recycler

import UserModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiController {
    @GET("user")
    fun list(): Call<UserModel>
}