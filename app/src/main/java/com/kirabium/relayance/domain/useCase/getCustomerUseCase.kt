package com.kirabium.relayance.domain.useCase

import com.kirabium.relayance.data.repository.CustomerRepository
import com.kirabium.relayance.domain.model.Customer
import javax.inject.Inject

class GetCustomerUseCase @Inject constructor(
    private val customerRepository: CustomerRepository
) {
    operator fun invoke(customerId: Int): Customer? = customerRepository.getCustomer(customerId)
}