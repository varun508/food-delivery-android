package com.trihkfoods.main.ui.main.explore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.trihkfoods.main.databinding.FragmentChefExploreBinding
import com.trihkfoods.main.ui.main.explore.adapters.ExploreChefListAdapter
import com.trihkfoods.main.tempmodels.Chef
import com.trihkfoods.main.tempmodels.FoodItem
import kotlinx.android.synthetic.main.fragment_chef_explore.*

class ChefExploreFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentChefExploreBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        inflateDummyChefList()
    }


    private fun inflateDummyChefList() {
        val foodItems = arrayListOf<FoodItem>()
        val chefs = arrayListOf<Chef>()

        repeat(10) { chefs += Chef(chefSpecials = foodItems) }

        rvChefExplore?.run {
            adapter = ExploreChefListAdapter(chefs)
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

}