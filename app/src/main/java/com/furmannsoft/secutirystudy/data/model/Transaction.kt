package com.furmannsoft.secutirystudy.data.model

data class Transaction(
    val transactionId: Long,
    val transactionPlace: String,
    val transactionMethod: String,
    val transactionAmout: String,
    val transactionDate: String
)
