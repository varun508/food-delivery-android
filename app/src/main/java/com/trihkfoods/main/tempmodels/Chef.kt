package com.trihkfoods.main.tempmodels

import com.trihkfoods.main.R

data class Chef(
    val chefId: String ="",
    val imageResource: Int = R.drawable.image_temp_chef,
    val chefSpecials: List<FoodItem> ,
    var expanded: Boolean = false
)