package com.trihkfoods.main.ui.cart

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.trihkfoods.main.R
import com.trihkfoods.main.databinding.ActivityCartBinding
import com.trihkfoods.main.tempmodels.Chef
import com.trihkfoods.main.tempmodels.FoodItem
import com.trihkfoods.main.utils.changeStatusBarColor
import kotlinx.android.synthetic.main.activity_cart.*

class CartActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_cart)
        changeStatusBarColor(R.color.white)

        inflateDummyCartList()
    }

    private fun inflateDummyCartList() {
        val chefs = mutableListOf<Chef>()
        repeat(2) {
            val dishes = listOf( FoodItem(), FoodItem())
            chefs += Chef(chefSpecials = dishes)
        }
        rvCartChef.adapter = CartChefListAdapter(chefs)
        rvCartChef.layoutManager =
            LinearLayoutManager(this).apply { orientation = RecyclerView.VERTICAL }
    }
}
