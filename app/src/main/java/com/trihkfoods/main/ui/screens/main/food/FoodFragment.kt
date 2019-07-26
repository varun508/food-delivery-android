package com.trihkfoods.main.ui.screens.main.food

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.trihkfoods.main.R
import com.trihkfoods.main.data.model.Offer
import com.trihkfoods.main.ui.adapters.MainChefListAdapter
import com.trihkfoods.main.ui.adapters.OfferListAdapter
import kotlinx.android.synthetic.main.fragment_food.*

class FoodFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_food, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = OfferListAdapter(
            arrayListOf(
                Offer("", "", "https://im4.ezgif.com/tmp/ezgif-4-03f6970fcd2d.png"),
                Offer("", "", "https://im4.ezgif.com/tmp/ezgif-4-03f6970fcd2d.png"),
                Offer("", "", "https://im4.ezgif.com/tmp/ezgif-4-03f6970fcd2d.png"),
                Offer("", "", "https://im4.ezgif.com/tmp/ezgif-4-03f6970fcd2d.png")
            )
        )

        rvOffers.adapter = adapter
        rvOffers.layoutManager = LinearLayoutManager(requireContext()).also {
            it.orientation = LinearLayout.HORIZONTAL
        }

        rvChefs.adapter = MainChefListAdapter()
        rvChefs.layoutManager= LinearLayoutManager(requireContext())

    }
}