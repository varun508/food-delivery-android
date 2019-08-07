package com.trihkfoods.main.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.trihkfoods.main.R
import com.trihkfoods.main.ui.cart.CartActivity
import com.trihkfoods.main.ui.location.LocationActivity
import com.trihkfoods.main.ui.main.account.AccountFragment
import com.trihkfoods.main.ui.main.explore.ExploreFragment
import com.trihkfoods.main.ui.main.food.FoodFragment
import com.trihkfoods.main.ui.main.offers.OffersFragment
import com.trihkfoods.main.utils.changeStatusBarColor
import com.trihkfoods.main.utils.navigateTo
import com.trihkfoods.main.utils.onClick
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_bottom_cart_main.*
import kotlinx.android.synthetic.main.layout_location_toolbar.*

class MainActivity : AppCompatActivity() {

    private val foodFragment by lazy { FoodFragment() }
    private val exploreFragment by lazy { ExploreFragment() }
    private val offersFragment by lazy { OffersFragment() }
    private val accountFragment by lazy { AccountFragment() }
    private var lastFragmentId = R.id.action_food_fragment

    private val fragmentTags by lazy {
        mapOf(
            R.id.action_food_fragment to foodFragment.javaClass.simpleName,
            R.id.action_explore_fragment to exploreFragment.javaClass.simpleName,
            R.id.action_cart_fragment to offersFragment.javaClass.simpleName,
            R.id.action_account_fragment to accountFragment.javaClass.simpleName
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        changeStatusBarColor(R.color.white)
        bindUI()
        handleClickEvents()
    }

    private fun bindUI() {
        setupNavigationItemListener()
        mainBottomNav.selectedItemId = R.id.action_food_fragment
    }

    private fun handleClickEvents() {
        layoutBottomViewCart.onClick { navigateTo(CartActivity::class.java) }
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
        findFragmentByTag(fragmentTags[lastFragmentId])?.let {
            beginTransaction().hide(it).commit()
        }
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
            R.id.action_cart_fragment -> offersFragment
            R.id.action_account_fragment -> accountFragment
            else -> foodFragment
        }

}
