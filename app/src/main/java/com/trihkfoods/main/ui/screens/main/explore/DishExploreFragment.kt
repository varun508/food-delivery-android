package com.trihkfoods.main.ui.screens.main.explore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.trihkfoods.main.databinding.FragmentDishExploreBinding
import com.trihkfoods.main.ui.screens.main.explore.adapters.ExploreDishListAdapter
import com.trihkfoods.main.tempmodels.FoodItem
import kotlinx.android.synthetic.main.fragment_dish_explore.*

class DishExploreFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDishExploreBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        inflateDummyDishList()
    }


    private fun inflateDummyDishList() {
        val foodItems = arrayListOf<FoodItem>()
        repeat(10) { foodItems += FoodItem() }

        rvDishExplore?.run {
            adapter = ExploreDishListAdapter(foodItems)
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

}