package com.trihkfoods.main.tempmodels

import com.trihkfoods.main.R

data class Card(
    val id: String = "000",
    val name: String = "Personal Card",
    val number: String = "5555 XXXX XXXX 4444",
    val image: Int = R.drawable.ic_mastercard
)