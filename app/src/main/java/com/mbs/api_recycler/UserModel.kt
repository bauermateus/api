package com.mbs.api_recycler
import com.google.gson.annotations.SerializedName


data class UserModel (

    @SerializedName("users" ) var users : ArrayList<Users> = arrayListOf()

)