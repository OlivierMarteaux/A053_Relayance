package com.kirabium.relayance.ui.activity

//import android.content.Intent
//import android.util.Log
//import androidx.compose.ui.test.assertIsDisplayed
//import androidx.compose.ui.test.junit4.createAndroidComposeRule
//import androidx.compose.ui.test.onNodeWithText
//import androidx.test.core.app.ActivityScenario
//import androidx.test.core.app.ApplicationProvider
//import com.kirabium.relayance.R
//import com.kirabium.relayance.data.service.DummyData
//import com.kirabium.relayance.extension.DateExt.Companion.toHumanDate
//import com.kirabium.relayance.ui.screens.detailScreen.DetailActivity
//import org.junit.Rule
//import org.junit.Test
//
//class DetailActivityTest {
//
//    @get:Rule
//    val composeTestRule = createAndroidComposeRule<DetailActivity>()
//
//    @Test
//    fun detailActivity_WithCustomerId_DisplaysCorrectCustomerData() {
//        // Given
//        val customer = DummyData.customers.first()
//        Log.d("OM_TAG", "Customer selected: $customer")
//        val createdAtString = composeTestRule.activity.getString(
//            R.string.created_at,
//            customer.createdAt.toHumanDate()
//        )
//        val newRibbonString = composeTestRule.activity.getString(R.string.new_ribbon)
//        val detailScreenTitle = composeTestRule.activity.getString(R.string.detail_screen_title)
//
//        // When
//        val intent = Intent(ApplicationProvider.getApplicationContext(), DetailActivity::class.java)
//            .putExtra(DetailActivity.EXTRA_CUSTOMER_ID, customer.id)
//        // Launch activity manually, do NOT use createAndroidComposeRule
//        val scenario = ActivityScenario.launch<DetailActivity>(intent)
//        scenario.onActivity { activity ->
//            // At this point, activity.intent has the correct customer ID
//            // Compose hierarchy is already set up
//        }
//
//        // Then
//        composeTestRule.onNodeWithText(customer.name).assertIsDisplayed()
//        Log.d("OM_TAG", "Customer name displayed assertion passed")
//        composeTestRule.onNodeWithText(customer.email).assertIsDisplayed()
//        Log.d("OM_TAG", "Customer email displayed assertion passed")
//        composeTestRule.onNodeWithText(createdAtString).assertIsDisplayed()
//        Log.d("OM_TAG", "Customer creation date displayed assertion passed")
//        if (customer.isNewCustomer()) {
//            composeTestRule.onNodeWithText(newRibbonString).assertIsDisplayed()
//        }
//        Log.d("OM_TAG", "Customer ribbon displayed assertion passed")
//        composeTestRule.onNodeWithText(detailScreenTitle).assertIsDisplayed()
//        Log.d("OM_TAG", "Detail screen title displayed assertion passed")
//    }
//}