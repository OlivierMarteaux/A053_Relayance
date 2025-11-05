package com.kirabium.relayance.data.repository

import com.kirabium.relayance.domain.model.Customer

interface CustomerRepository {

    fun getAllCustomers(): List<Customer>
    fun getCustomer(customerId: Int): Customer?

    fun addCustomer(customer: Customer)

}