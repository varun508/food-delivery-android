package com.trihkfoods.main

import android.content.Context
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication

class BaseApplication : MultiDexApplication() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}