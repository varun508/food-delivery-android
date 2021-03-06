package com.trihkfoods.main.ui.main.explore.adapters

import androidx.fragment.app.FragmentManager
import com.trihkfoods.main.adapters.BaseFragmentPagerAdapter
import com.trihkfoods.main.ui.main.explore.ChefExploreFragment
import com.trihkfoods.main.ui.main.explore.DishExploreFragment

class ExploreViewPagerAdapter(fragmentManager: FragmentManager) :
    BaseFragmentPagerAdapter(fragmentManager) {

    /** Use dependency injection to get instances of these fragments */
    init {
        addFragments(
            ChefExploreFragment(),
            DishExploreFragment()
        )
    }

    override fun getPageTitle(position: Int) = when (position) {
        0 -> "Chefs"
        1 -> "Dishes"
        else -> ""
    }
}