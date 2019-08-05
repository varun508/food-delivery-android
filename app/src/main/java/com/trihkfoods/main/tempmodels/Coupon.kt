package com.trihkfoods.main.tempmodels

data class Coupon(
    val id: String,
    val imageResource: Int,
    val title: String,
    val body: String,
    val tnc: List<String>
)
