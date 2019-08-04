package com.trihkfoods.main.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

open class BaseFragmentPagerAdapter(fragmentManager: FragmentManager) :
    FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val fragments = mutableListOf<Fragment>()

    override fun getCount() = fragments.size

    override fun getItem(position: Int) = fragments[position]

    fun addFragment(fragment: Fragment) {
        fragments += fragment
    }

    fun addFragments(vararg fragments: Fragment) {
        fragments.forEach { this.fragments += it }
    }

}