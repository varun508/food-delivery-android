package com.trihkfoods.main.ui.screens.main.explore.adapters

import androidx.fragment.app.FragmentManager
import com.trihkfoods.main.ui.adapters.BaseFragmentPagerAdapter
import com.trihkfoods.main.ui.screens.main.explore.ChefExploreFragment
import com.trihkfoods.main.ui.screens.main.explore.DishExploreFragment

class ExploreViewPagerAdapter(fragmentManager: FragmentManager) :
    BaseFragmentPagerAdapter(fragmentManager) {

    /** Use dependency injection to get instances of these fragments */
    init {
        addFragments(ChefExploreFragment(), DishExploreFragment())
    }
}