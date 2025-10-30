package com.kirabium.relayance.data.repository

import com.kirabium.relayance.data.service.CustomerApi
import com.kirabium.relayance.domain.model.Customer
import javax.inject.Inject

class CustomerLocalRepository @Inject constructor(private val customerApi: CustomerApi)
    : CustomerRepository {

    override fun getAllCustomers(): List<Customer> = customerApi.customers
    override fun getCustomer(customerId: Int): Customer? =
        getAllCustomers().find { it.id == customerId }

}