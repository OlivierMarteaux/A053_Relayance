package com.kirabium.relayance.ui.navigation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(): ViewModel() {

    //_ show the toast on home screen in case a new customer has been created from add screen
    var newCustomerCreated: Boolean by mutableStateOf(false)
        private set
    fun showUserCreatedToast() {newCustomerCreated = true}

}