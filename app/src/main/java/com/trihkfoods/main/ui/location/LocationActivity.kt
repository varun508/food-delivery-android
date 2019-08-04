package com.trihkfoods.main.ui.location

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.trihkfoods.main.R
import com.trihkfoods.main.databinding.ActivityLocationBinding
import com.trihkfoods.main.utils.changeStatusBarColor

class LocationActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityLocationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_location)
        changeStatusBarColor(R.color.white)
    }
}
