package com.kirabium.relayance.ui.activity

//import android.content.Intent
//import android.util.Log
//import androidx.compose.ui.test.assertIsDisplayed
//import androidx.compose.ui.test.junit4.createAndroidComposeRule
//import androidx.compose.ui.test.onAllNodesWithText
//import androidx.compose.ui.test.onNodeWithText
//import androidx.test.core.app.ApplicationProvider
//import androidx.test.espresso.intent.Intents
//import com.kirabium.relayance.R
//import com.kirabium.relayance.data.DummyData
//import com.kirabium.relayance.domain.model.Customer
//import com.kirabium.relayance.extension.DateExt.Companion.toHumanDate
//import org.junit.Rule
//import org.junit.Test
//import org.junit.runner.RunWith
//import androidx.test.ext.junit.runners.AndroidJUnit4
//import org.junit.After
//import org.junit.Before
//
//@RunWith(AndroidJUnit4::class)
//class DetailActivityTest {
//
//    // Compose test rule will launch DetailActivity automatically
//    @get:Rule
//    val composeTestRule = createAndroidComposeRule<DetailActivity>()
//
//    @Test
//    fun detailActivity_WithCustomerId_DisplaysCorrectCustomerData() {
//        val customer = DummyData.customers.first()
//        Log.d("OM_TAG", "Customer selected: $customer")
//
//        val intent = Intent(ApplicationProvider.getApplicationContext(), DetailActivity::class.java)
//            .putExtra(DetailActivity.EXTRA_CUSTOMER_ID, customer.id)
//
//        composeTestRule.activityRule.scenario.onActivity { activity ->
//            activity.intent = intent
//            activity.recreate()
//            Log.d("OM_TAG", "Activity recreated with intent")
//        }
//
//        Log.d("OM_TAG", "Waiting for Compose UI")
//        composeTestRule.waitUntil(timeoutMillis = 2000) {
//            composeTestRule.onAllNodesWithText(customer.name).fetchSemanticsNodes().isNotEmpty()
//        }
//        Log.d("OM_TAG", "UI node for customer name found")
//
//        composeTestRule.onNodeWithText(customer.name).assertIsDisplayed()
//        Log.d("OM_TAG", "Customer name displayed assertion passed")
//    }
//}