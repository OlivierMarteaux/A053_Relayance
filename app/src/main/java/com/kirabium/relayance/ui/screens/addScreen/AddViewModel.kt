package com.kirabium.relayance.ui.screens.addScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.kirabium.relayance.data.repository.CustomerRepository
import com.kirabium.relayance.domain.model.Customer
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class AddViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val customerRepository: CustomerRepository
): ViewModel() {

    private val newCustomerId: Int = checkNotNull(savedStateHandle["new_customer_id"])

    var name: String by mutableStateOf("")
        private set
    var email: String by mutableStateOf("")
        private set
    var userCreated: Boolean by mutableStateOf(false)
        private set

    fun onNameChange(newName: String) { name = newName }
    fun onEmailChange(newEmail: String) { email = newEmail }

    fun addCustomer(onCustomerAdded: () -> Unit) {
        customerRepository.addCustomer(
            Customer(
                id = newCustomerId,
                name = name,
                email = email,
                createdAt = Date()
            )
        )
        onCustomerAdded()
    }
}