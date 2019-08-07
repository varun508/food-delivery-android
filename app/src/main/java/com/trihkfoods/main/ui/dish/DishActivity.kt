package com.trihkfoods.main.ui.dish

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.trihkfoods.main.R
import com.trihkfoods.main.databinding.ActivityDishBinding
import com.trihkfoods.main.utils.onClick
import kotlinx.android.synthetic.main.activity_dish.*

class DishActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityDishBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_dish)

        tvAddToCartDishAct.onClick {
            tvAddToCartDishAct.visibility = View.GONE
            itemCounterDishAct.visibility = View.VISIBLE
        }

        itemCounterDishAct.doOnIncrement {

        }

        itemCounterDishAct.doOnDecrement {
            if(it == 0)
        }
    }
}
