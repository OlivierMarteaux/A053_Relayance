package com.kirabium.relayance.ui.activity

import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.intent.matcher.IntentMatchers.hasExtra
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.kirabium.relayance.R
import com.kirabium.relayance.data.DummyData
import com.kirabium.relayance.ui.adapter.CustomerAdapter
import com.kirabium.relayance.util.RecyclerViewItemCountAssertion
import org.hamcrest.CoreMatchers.`is`
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.hamcrest.CoreMatchers.allOf

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
        // Initialize Espresso-Intents before running tests
        Intents.init()
    }

    @After
    fun tearDown() {
        // Release Espresso-Intents after tests
        Intents.release()
    }

    @Test
    fun mainActivity_OnAppStart_DisplaysFiveCustomerEntries() {
        // Given: The app is launched and MainActivity is displayed
        // (Handled by ActivityScenarioRule)

        // When: The RecyclerView with customer list is visible

        // Then: There should be exactly 5 customer items displayed
        onView(withId(R.id.customerRecyclerView))
            .check(RecyclerViewItemCountAssertion(`is`(5)))
    }

    @Test
    fun mainActivity_OnFirstItemClick_NavigatesToDetailActivityWithCorrectId() {
        // Given: The MainActivity is displayed with the customer list
        val expectedCustomer = DummyData.customers.first()
        val expectedId = expectedCustomer.id

        // When: User clicks on the first item ("Alice Wonderland")
        onView(withId(R.id.customerRecyclerView))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<CustomerAdapter.CustomerViewHolder>(
                    0, click()
                )
            )

        // Then: Verify that DetailActivity is launched with the correct customer ID
        Intents.intended(
            allOf(
                hasComponent(DetailActivity::class.java.name),
                hasExtra(DetailActivity.EXTRA_CUSTOMER_ID, expectedId)
            )
        )
    }
}