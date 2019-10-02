package com.example.myapplication.basic_api.data

import com.google.gson.JsonObject

data class DeeplinkTransactionBody (
    val transactionType : String = "PURCHASE",
    val transactionSubType: List<String> = arrayListOf("BP"),
    val sessionValidityPeriod: Int,
    val sessionValidUntil: String,
    val billPayment:BillPaymentModel
//    val creditCardFullAmount: CreditCardFullAmountModel
) {

}