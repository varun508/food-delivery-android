package com.trihkfoods.main.ui.screens.authentication

import androidx.lifecycle.ViewModel

class AuthenticationViewModel : ViewModel() {

}

enum class AuthenticationState {
    REST, BUSY, ERROR, SUCCESS
}
