package com.example.myapplication.basic_api.data

import com.google.gson.annotations.SerializedName

data class TokenModel(
    @SerializedName("status")
    val status: StatusModel?,

    @SerializedName("data")
    val data: dataDetail?

)