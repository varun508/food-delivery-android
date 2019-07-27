package com.trihkfoods.main.ui.tempmodels

data class Chef(
    val chefId: String,
    val imageResource: Int,
    val foodResource: Int,
    val chefSpecials: List<FoodItem>
)