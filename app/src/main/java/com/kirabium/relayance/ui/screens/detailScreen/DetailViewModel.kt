package com.kirabium.relayance.ui.screens.detailScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.kirabium.relayance.data.repository.CustomerRepository
import com.kirabium.relayance.domain.model.Customer
import com.oliviermarteaux.shared.utils.AndroidLogger
import com.oliviermarteaux.shared.utils.Logger
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val customerRepository: CustomerRepository,
    private val log: Logger = AndroidLogger
) : ViewModel() {
    private val customerId: Int = checkNotNull(savedStateHandle["customer_id"])

    var customer: Customer by mutableStateOf(Customer())
        private set

    private fun loadCustomer() {
        customer = customerRepository.getCustomer(customerId) ?: Customer()
        log.d("DetailViewModel: loading customer with Id: $customerId")
    }

    init { loadCustomer() }
}