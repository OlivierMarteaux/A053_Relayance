package com.kirabium.relayance.domain.model

import org.junit.Test
import java.util.Date
import org.junit.Assert.*
import java.util.Calendar

class CustomerTest {

    private lateinit var creationDate: Date

    @Test
    fun customer_CreatedToday_ReturnsTrue() {
        val creationDate = Date()
        val customer = Customer(1, "Alice", "alice@example.com", creationDate)

        assertTrue(customer.isNewCustomer())
    }

    @Test
    fun customer_CreatedOneMonthAgo_ReturnsTrue() {
        val creationDate = Calendar.getInstance().apply { add(Calendar.MONTH, -1) }.time
        val customer = Customer(2, "Bob", "bob@example.com", creationDate)

        assertTrue(customer.isNewCustomer())
    }

    @Test
    fun customer_CreatedThreeMonthsAgo_ReturnsTrue() {
        val creationDate = Calendar.getInstance().apply { add(Calendar.MONTH, -3) }.time
        val customer = Customer(3, "Charlie", "charlie@example.com", creationDate)

        // createdAt exactly 3 months ago counts as new
        assertTrue(customer.isNewCustomer())
    }

    @Test
    fun customer_CreatedFourMonthsAgo_ReturnsFalse() {
        val creationDate = Calendar.getInstance().apply { add(Calendar.MONTH, -4) }.time
        val customer = Customer(4, "Diana", "diana@example.com", creationDate)

        assertFalse(customer.isNewCustomer())
    }

    @Test
    fun customer_CreatedSixMonthsAgo_ReturnsFalse() {
        val creationDate = Calendar.getInstance().apply { add(Calendar.MONTH, -6) }.time
        val customer = Customer(5, "Evan", "evan@example.com", creationDate)

        assertFalse(customer.isNewCustomer())
    }
}