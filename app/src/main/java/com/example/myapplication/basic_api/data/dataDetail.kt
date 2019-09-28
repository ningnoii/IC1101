package com.example.myapplication.basic_api.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class dataDetail(@SerializedName("accessToken")
                 val accessToken: String,

                      @SerializedName("tokenType")
                 val tokenType: String,

                      @SerializedName("expiresIn")
                 val expiresIn: Int,

                      @SerializedName("expiresAt")
                 val expiresAt: Int)
    : Parcelable
