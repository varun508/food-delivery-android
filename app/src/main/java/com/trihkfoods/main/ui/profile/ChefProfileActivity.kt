package com.trihkfoods.main.ui.profile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.trihkfoods.main.R
import com.trihkfoods.main.databinding.ActivityChefProfileBinding
import com.trihkfoods.main.tempmodels.Chef

class ChefProfileActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityChefProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_chef_profile)
        _binding.chef = Chef()
    }
}
