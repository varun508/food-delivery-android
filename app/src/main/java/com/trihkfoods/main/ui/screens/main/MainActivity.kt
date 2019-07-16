package com.trihkfoods.main.ui.screens.main

import android.accounts.Account
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.trihkfoods.main.R
import com.trihkfoods.main.ui.screens.main.account.AccountFragment
import com.trihkfoods.main.ui.screens.main.cart.CartFragment
import com.trihkfoods.main.ui.screens.main.explore.ExploreFragment
import com.trihkfoods.main.ui.screens.main.food.FoodFragment
import com.trihkfoods.main.utils.changeStatusBarColor
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val foodFragment by lazy { FoodFragment() }
    private val exploreFragment by lazy { ExploreFragment() }
    private val cartFragment by lazy { CartFragment() }
    private val accountFragment by lazy { AccountFragment() }
    private var lastFragmentId = R.id.action_food_fragment

    private val fragmentTags by lazy {
        mapOf(
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
        bindUI()
    }

    private fun bindUI() {
        setupNavigationItemListener()
        mainBottomNav.selectedItemId = R.id.action_food_fragment
    }

    private fun setupNavigationItemListener() {
        mainBottomNav.setOnNavigationItemSelectedListener {
            supportFragmentManager.run {
                val tag = fragmentTags[it.itemId]
                if (findFragmentByTag(tag) == null) addFragment(it.itemId, tag!!)
                updateUI(it.itemId)
            }
            return@setOnNavigationItemSelectedListener true
        }
    }

    private fun FragmentManager.updateUI(id: Int) {
        hideLastFragment()
        showSelectedFragment(id)
    }

    private fun FragmentManager.hideLastFragment() {
        findFragmentByTag(fragmentTags[lastFragmentId])?.let { beginTransaction().hide(it).commit() }
    }

    private fun FragmentManager.showSelectedFragment(id: Int) {
        findFragmentByTag(fragmentTags[id])?.let {
            beginTransaction().show(it).commit()
        }
        lastFragmentId = id
    }

    private fun FragmentManager.addFragment(id: Int, tag: String) {
        beginTransaction().add(R.id.mainFragmentContainer, getFragmentById(id), tag)
                .commit()
    }

    private fun getFragmentById(id: Int) =
            when (id) {
                R.id.action_food_fragment -> foodFragment
                R.id.action_explore_fragment -> exploreFragment
                R.id.action_cart_fragment -> cartFragment
                R.id.action_account_fragment -> accountFragment
                else -> foodFragment
            }

}
