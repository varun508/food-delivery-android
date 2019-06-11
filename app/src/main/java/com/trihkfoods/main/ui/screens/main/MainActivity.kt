package com.trihkfoods.main.ui.screens.main

import android.accounts.Account
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.trihkfoods.main.R
import com.trihkfoods.main.ui.screens.main.account.AccountFragment
import com.trihkfoods.main.ui.screens.main.cart.CartFragment
import com.trihkfoods.main.ui.screens.main.explore.ExploreFragment
import com.trihkfoods.main.ui.screens.main.food.FoodFragment

class MainActivity : AppCompatActivity() {

    private val foodFragment = FoodFragment()
    private val exploreFragment = ExploreFragment()
    private val cartFragment = CartFragment()
    private val accountFragment = AccountFragment()
    private var lastFragmentId = R.id.food_fragment

    private val fragmentTags by lazy {
        mapOf<Int, String>(
                R.id.food_fragment to foodFragment.javaClass.simpleName,
                R.id.feed_fragment to mFeedFragment.javaClass.simpleName,
                R.id.group_fragment to mGroupFragment.javaClass.simpleName,
                R.id.notification_fragment to mNotificationFragment.javaClass.simpleName
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
