package com.trihkfoods.main.tempmodels

data class PaymentOffer(
    val id: String = "",
    val imageResource: Int = 0,
    val title: String = "",
    val body: String = "",
    val tnc: List<String> = listOf()
)
