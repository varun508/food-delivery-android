package com.trihkfoods.main.ui.main.food

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
import com.trihkfoods.main.tempmodels.Chef
import com.trihkfoods.main.tempmodels.FoodItem
import com.trihkfoods.main.tempmodels.Offer
import com.trihkfoods.main.ui.dish.DishActivity
import com.trihkfoods.main.ui.location.LocationActivity
import com.trihkfoods.main.ui.profile.ChefProfileActivity
import com.trihkfoods.main.utils.navigateTo
import com.trihkfoods.main.utils.onClick
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

        include.onClick { activity?.navigateTo(LocationActivity::class.java) }

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
        val foodItems = arrayListOf<FoodItem>()
        repeat(3) { foodItems += FoodItem() }

        val chefs = arrayListOf<Chef>()
        repeat(10) { chefs += Chef(chefSpecials = foodItems) }

        rvChefs?.run {
            adapter = MainChefListAdapter(chefs = chefs,
                onViewAllClick = {
                    activity?.run { navigateTo(ChefProfileActivity::class.java) }
                },
                onDishItemClick = {
                    activity?.run { navigateTo(DishActivity::class.java) }
                })
            layoutManager = LinearLayoutManager(requireContext())
        }
    }
}