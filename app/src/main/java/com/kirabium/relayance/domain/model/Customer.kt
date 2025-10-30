package com.kirabium.relayance.domain.model

import java.util.Calendar
import java.util.Date
import java.util.UUID

data class Customer(
    val id: Int = 0,
    val name: String = "",
    val email: String = "",
    val createdAt: Date = Date(),
) {
    fun isNewCustomer(): Boolean {
        val today = Calendar.getInstance()
        val createdAtCalendar = Calendar.getInstance().apply {
            time = createdAt
        }
        today.add(Calendar.MONTH, -3)
        return !createdAtCalendar.before(today)
    }
}
