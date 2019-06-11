package com.trihkfoods.main.ui.screens.main

import android.accounts.Account
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.trihkfoods.main.R
import com.trihkfoods.main.ui.screens.main.account.AccountFragment
import com.trihkfoods.main.ui.screens.main.cart.CartFragment
import com.trihkfoods.main.ui.screens.main.explore.ExploreFragment
import com.trihkfoods.main.ui.screens.main.food.FoodFragment
import com.trihkfoods.main.utils.changeStatusBarColor

class MainActivity : AppCompatActivity() {

    private val foodFragment = FoodFragment()
    private val exploreFragment = ExploreFragment()
    private val cartFragment = CartFragment()
    private val accountFragment = AccountFragment()
    private var lastFragmentId = R.id.action_food_fragment

    private val fragmentTags by lazy {
        mapOf<Int, String>(
                R.id.action_food_fragment to foodFragment.javaClass.simpleName,
                R.id.action_explore_fragment to exploreFragment.javaClass.simpleName,
                R.id.action_cart_fragment to cartFragment.javaClass.simpleName,
                R.id.action_account_fragment to accountFragment.javaClass.simpleName
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        changeStatusBarColor(R.color.white)
    }
}
