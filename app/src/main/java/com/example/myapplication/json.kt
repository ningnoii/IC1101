package com.example.myapplication

data class RequestBody(
    val billPayment: BillPayment,
    val sessionValidUntil: String,
    val sessionValidityPeriod: Int,
    val transactionSubType: List<String>,
    val transactionType: String
)

data class BillPayment(
    val accountTo: String,
    val paymentAmount: Int,
    val ref1: String,
    val ref2: String,
    val ref3: String
)