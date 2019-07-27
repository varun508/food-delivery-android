package com.trihkfoods.main.ui.screens.main.food

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.trihkfoods.main.R
import com.trihkfoods.main.databinding.FragmentFoodBinding
import com.trihkfoods.main.ui.adapters.MainChefListAdapter
import com.trihkfoods.main.ui.adapters.OfferListAdapter
import com.trihkfoods.main.ui.tempmodels.Chef
import com.trihkfoods.main.ui.tempmodels.Offer
import kotlinx.android.synthetic.main.fragment_food.*

class FoodFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentFoodBinding>(
            inflater,
            R.layout.fragment_food,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        inflateDummyChefList()
        inflateDummyOfferList()
    }

    private fun inflateDummyOfferList() {
        val offers = arrayListOf<Offer>()
        repeat(4) { offers += Offer("", "", R.drawable.image_temp_offer) }

        rvOffers?.run {
            adapter = OfferListAdapter(offers)
            layoutManager = LinearLayoutManager(requireContext()).also {
                it.orientation = LinearLayout.HORIZONTAL
            }
        }
    }

    private fun inflateDummyChefList() {
        val chefs = arrayListOf<Chef>()
        repeat(4) { chefs += Chef("", R.drawable.image_temp_chef, R.drawable.image_temp_food_item) }

        rvChefs?.run {
            adapter = MainChefListAdapter(chefs)
            layoutManager = LinearLayoutManager(requireContext())
        }
    }
}