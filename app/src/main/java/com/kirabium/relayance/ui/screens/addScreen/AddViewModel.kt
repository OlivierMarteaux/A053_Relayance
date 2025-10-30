package com.kirabium.relayance.ui.screens.addScreen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.kirabium.relayance.data.repository.CustomerRepository
import javax.inject.Inject
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class AddViewModel @Inject constructor(private val customerRepository: CustomerRepository)
    : ViewModel() {

    var name: String by mutableStateOf("")
        private set

    var email: String by mutableStateOf("")
        private set

    fun onNameChange(newName: String) {
        name = newName
    }

    fun onEmailChange(newEmail: String) {
        email = newEmail
    }

//    suspend fun createCustomer() {
//        customerRepository.createCustomer(name, email)

}