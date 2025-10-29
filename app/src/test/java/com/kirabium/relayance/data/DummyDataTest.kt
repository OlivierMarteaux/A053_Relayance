package com.kirabium.relayance.data

import org.junit.Test
import org.junit.Assert.*
import java.util.Calendar

class DummyDataTest {

    private var monthsBack: Int = 0

    @Test
    fun generateDate_ZeroMonthsSubtracted_ReturnsCorrectDate() {
        // Given
        monthsBack = 0
        val expected = Calendar.getInstance()
        expected.add(Calendar.MONTH, -monthsBack)
        // When
        val result = DummyData.generateDate(monthsBack)
        val resultCal = Calendar.getInstance().apply { time = result }
        // Then
        assertEquals(expected.get(Calendar.YEAR), resultCal.get(Calendar.YEAR))
        assertEquals(expected.get(Calendar.MONTH), resultCal.get(Calendar.MONTH))
    }

    @Test
    fun generateDate_SixMonthsSubtracted_ReturnsCorrectDate() {
        // Given
        monthsBack = 6
        val expected = Calendar.getInstance()
        expected.add(Calendar.MONTH, -monthsBack)
        // When
        val result = DummyData.generateDate(monthsBack)
        val resultCal = Calendar.getInstance().apply { time = result }
        // Then
        assertEquals(expected.get(Calendar.YEAR), resultCal.get(Calendar.YEAR))
        assertEquals(expected.get(Calendar.MONTH), resultCal.get(Calendar.MONTH))
    }

    @Test
    fun generateDate_TwelveMonthsSubtracted_ReturnsCorrectDate() {
        // Given
        monthsBack = 12
        val expected = Calendar.getInstance()
        expected.add(Calendar.MONTH, -monthsBack)
        // When
        val result = DummyData.generateDate(monthsBack)
        val resultCal = Calendar.getInstance().apply { time = result }
        // Then
        assertEquals(expected.get(Calendar.YEAR), resultCal.get(Calendar.YEAR))
        assertEquals(expected.get(Calendar.MONTH), resultCal.get(Calendar.MONTH))
    }
}