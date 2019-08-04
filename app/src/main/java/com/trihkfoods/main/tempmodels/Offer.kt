package com.trihkfoods.main.tempmodels

import com.trihkfoods.main.R

data class Offer(
    val offerId: String ="",
    val description: String="",
    val imageResource: Int = R.drawable.image_temp_offer
)