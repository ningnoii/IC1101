package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.TokenWatcher
import com.example.myapplication.basic_api.data.ExampleData
import com.example.myapplication.basic_api.data.TokenModel
import com.example.myapplication.basic_api.service.SCBManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        testApi()
    }
    fun testApi() {
        println("ningnananoii")
        val ex = ExampleData("l7f031d768df40465ba05ae327022a5220" , "8e25c09a6e0a4adeabfd6f50742c969d")
        SCBManager().createService().getToken(exampleData = ex).enqueue(object : Callback<TokenModel> {

            override fun onFailure(call: Call<TokenModel>, t: Throwable) {
                println("ningnananoii > FAILED ! $t")

            }

            override fun onResponse(call: Call<TokenModel>, response: Response<TokenModel>) {
                println("ningnananoii > have data")
                println("ningnanaoii > " + response.body())
                response.body()?.apply {
                    println("ningnananoii > have data2")
                }


            }

        })
        println("ningnananoii end")
    }
}
