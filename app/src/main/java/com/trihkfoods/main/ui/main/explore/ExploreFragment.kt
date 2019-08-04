package com.trihkfoods.main.ui.main.explore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.trihkfoods.main.R
import com.trihkfoods.main.databinding.FragmentExploreBinding
import com.trihkfoods.main.ui.main.explore.adapters.ExploreViewPagerAdapter
import kotlinx.android.synthetic.main.fragment_explore.*

class ExploreFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentExploreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewPager()
    }

    private fun setupViewPager() {
        vpExplore.adapter =
            ExploreViewPagerAdapter(
                childFragmentManager
            )
        tlExplore.setupWithViewPager(vpExplore)
        context?.run {
            tlExplore.setTabTextColors(
                ContextCompat.getColor(this, R.color.gray),
                ContextCompat.getColor(this, R.color.black)
            )
        }
    }
}