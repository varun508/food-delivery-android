package com.trihkfoods.main.ui.profile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.trihkfoods.main.R
import com.trihkfoods.main.databinding.ActivityChefProfileBinding

class ChefProfileActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityChefProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chef_profile)
    }
}
