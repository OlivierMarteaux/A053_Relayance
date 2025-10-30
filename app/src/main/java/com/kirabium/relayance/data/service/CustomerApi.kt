package com.kirabium.relayance.data.service

import com.kirabium.relayance.domain.model.Customer

interface CustomerApi {

    val customers: List<Customer>

}