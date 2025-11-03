package com.kirabium.relayance.ui.navigation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(): ViewModel() {

    //_ trigger the toast when customer is created on add screen
    var newCustomerCreated: Boolean by mutableStateOf(false)
        private set
    fun showUserCreatedToast() {newCustomerCreated = true}

//    //_ show the toast on home screen in case a new customer has been created from add screen
//    private var userCreatedToast: Boolean by mutableStateOf(false)

//    fun showUserCreatedToast() = viewModelScope.launch { showToastFlag { userCreatedToast = it } }

}