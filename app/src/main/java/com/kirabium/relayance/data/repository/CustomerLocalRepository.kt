package com.kirabium.relayance.data.repository

import com.kirabium.relayance.data.service.CustomerApi
import com.kirabium.relayance.domain.model.Customer

class CustomerLocalRepository(private val customerApi: CustomerApi): CustomerRepository {

    override fun getAllCustomers(): List<Customer> = customerApi.customers

}