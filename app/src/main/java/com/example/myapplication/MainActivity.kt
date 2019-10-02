package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.TokenWatcher
import com.example.myapplication.basic_api.data.*
import com.example.myapplication.basic_api.service.HeaderInfo
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
        var token:TokenModel;
        println("ningnananoii")
        val ex = ExampleData("l7f031d768df40465ba05ae327022a5220" , "8e25c09a6e0a4adeabfd6f50742c969d")
        val billPayment = BillPaymentModel(100)
        var creditCard = CreditCardFullAmountModel(paymentAmount = 100)
        val bodyDeeplink = DeeplinkTransactionBody(billPayment = billPayment,sesisionValidUntil = "",sessionValidityPeriod = 60);
            //creditCardFullAmount = creditCard
        SCBManager().createService().getToken(exampleData = ex).enqueue(object : Callback<TokenModel> {

            override fun onFailure(call: Call<TokenModel>, t: Throwable) {
                println("ningnananoii > FAILED ! $t")

            }

            override fun onResponse(call: Call<TokenModel>, response: Response<TokenModel>) {
                println("ningnananoii > have data")
                println("ningnanaoii > " + response.body())
                println("ningnanaoii > " + ex)
                response.body()?.apply {
                        token = this

                    println("ningnananoii > have data2"+ token)
                    apiDeeplinkTeansaction(token, bodyDeeplink)
                }


            }

        })

        println("ningnananoii end")
    }
    fun apiDeeplinkTeansaction(token: TokenModel, bodyDeeplink: DeeplinkTransactionBody){
        var scbManager: SCBManager = SCBManager()
        println("ningnananoii > go to depplink"+ token)
        val accessToken: String
        if(token.data!!.accessToken.isNotEmpty()){
            accessToken = token.data!!.accessToken
            println("ningnananoii > have access token"+ accessToken)
            scbManager.setHeaderDeeplinkTransactionService(accessToken)
        }

        scbManager.createDeeplinkTransactionService().createsTransaction(body = bodyDeeplink).enqueue(object : Callback<DeeplinkTransactionModel> {

            override fun onFailure(call: Call<DeeplinkTransactionModel>, t: Throwable) {
                println("ningnananoii > deeplink FAILED ! $t")

            }

            override fun onResponse(call: Call<DeeplinkTransactionModel>, response: Response<DeeplinkTransactionModel>) {
                println("ningnananoii > depplinkb have data ")
                println("ningnanaoii > " + response)
                println("ningnanaoii > " + bodyDeeplink)
                response.body()?.apply {

                    println("ningnananoii > deeplink have data2")
                }


            }

        })

    }
}
