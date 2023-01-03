package com.mbs.api_recycler

import com.google.gson.annotations.SerializedName


data class Users (

    @SerializedName("id"      ) var id      : Int?    = null,
    @SerializedName("name"    ) var name    : String? = null,
    @SerializedName("surname" ) var surname : String? = null,
    @SerializedName("active"  ) var active  : Int?    = null,
    @SerializedName("cpf"     ) var cpf     : String? = null,
    @SerializedName("email"   ) var email   : String? = null

)