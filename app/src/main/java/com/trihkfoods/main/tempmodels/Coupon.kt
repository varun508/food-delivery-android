package com.trihkfoods.main.tempmodels

data class Coupon(
    val id: String = "",
    val couponCode: String ="",
    val imageResource: Int =0,
    val title: String = "",
    val body: String = "",
    val tnc: List<String> = listOf()
)
