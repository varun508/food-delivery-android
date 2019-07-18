package com.trihkfoods.main.ui.screens.authentication

import androidx.lifecycle.ViewModel
import com.trihkfoods.main.data.network.ServiceGenerator
import com.trihkfoods.main.data.network.service.AuthService
import com.trihkfoods.main.utils.debugLog
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AuthenticationViewModel : ViewModel() {

    init {
        GlobalScope.launch(Dispatchers.IO) {
            try {
                val result = ServiceGenerator.createService(AuthService::class.java).checkUserExistence("9871235033")
                debugLog("result", result.toString())
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}

enum class AuthenticationState {
    REST, BUSY, ERROR, SUCCESS
}
