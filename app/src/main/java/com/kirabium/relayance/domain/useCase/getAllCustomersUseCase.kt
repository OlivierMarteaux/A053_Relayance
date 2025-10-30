package com.kirabium.relayance.domain.useCase

import com.kirabium.relayance.data.repository.CustomerRepository
import com.kirabium.relayance.domain.model.Customer
import javax.inject.Inject

class GetAllCustomersUseCase @Inject constructor(
    private val customerRepository: CustomerRepository
) {
    operator fun invoke(): List<Customer> = customerRepository.getAllCustomers()
}