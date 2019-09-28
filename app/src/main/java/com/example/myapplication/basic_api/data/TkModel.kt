package com.example.myapplication.basic_api.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


data class TkModel (
    @SerializedName("status")
    val status : StatusModel?,

    @SerializedName("data")
    val data1 : dataDetail?

)