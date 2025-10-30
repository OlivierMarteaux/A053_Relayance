package com.kirabium.relayance.ui.screens.homeScreen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.kirabium.relayance.data.repository.CustomerRepository
import com.kirabium.relayance.domain.model.Customer
import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.kirabium.relayance.domain.useCase.GetAllCustomersUseCase
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getAllCustomersUseCase: GetAllCustomersUseCase)
    : ViewModel() {

    var customers: List<Customer> by mutableStateOf(emptyList())
        private set

    private fun loadCustomers() { customers = getAllCustomersUseCase() }

    init { loadCustomers() }
}