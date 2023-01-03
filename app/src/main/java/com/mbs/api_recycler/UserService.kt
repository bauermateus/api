package com.mbs.api_recycler

import retrofit2.Call
import retrofit2.http.GET

interface UserService {
    @GET("user")
    fun list(): Call<List<UserModel>>
}