package com.trihkfoods.main.ui.payment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.trihkfoods.main.R
import com.trihkfoods.main.databinding.ActivitySetPaymentMethodBinding
import com.trihkfoods.main.tempmodels.Card
import com.trihkfoods.main.tempmodels.Wallet
import com.trihkfoods.main.utils.changeStatusBarColor
import kotlinx.android.synthetic.main.activity_set_payment_method.*

class SetPaymentMethodActivity : AppCompatActivity() {

    private lateinit var _binding: ActivitySetPaymentMethodBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_set_payment_method)

        changeStatusBarColor(R.color.white)

        inflateDummyPaymentMethodList()
    }

    private fun inflateDummyPaymentMethodList() {
        val items = mutableListOf<Any>()
        items += Wallet()
        items += Card()
        items += Wallet(image = R.drawable.ic_amazon_pay_logo, name = "Amazon Pay Wallet")
        items += Wallet(image = R.drawable.ic_freecharge_logo, name = "Freecharge Wallet")

        rvSavedPaymentMethod.run {
            adapter = SetPaymentMethodListAdapter(items)
            layoutManager = LinearLayoutManager(this@SetPaymentMethodActivity).apply { orientation = RecyclerView.VERTICAL }
        }
    }
}
