package com.trihkfoods.main.tempmodels

import com.trihkfoods.main.R

data class Chef(
    val chefId: String = "",
    val imageResource: Int = R.drawable.image_temp_chef,
    val chefSpecials: List<FoodItem> = listOf(),
    var expanded: Boolean = false,
    val backgroundImageResource: Int = R.drawable.image_temp_chef_background
)