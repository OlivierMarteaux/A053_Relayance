package com.kirabium.relayance.cucumber.steps

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasScrollAction
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performScrollToIndex
import com.kirabium.relayance.di.ComposeRuleHolder
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then

class HomeSteps(private val composeRuleHolder: ComposeRuleHolder) {

        private val composeRule = composeRuleHolder.composeRule

    @Given("I am on the Home screen")
    @Then("I should return to the Home screen")
    fun iAmOnTheHomeScreen() {
        // Verify some known customers are shown
        composeRule.onNodeWithText("Alice Wonderland").assertIsDisplayed()
        composeRule.onNodeWithText("Bob Builder").assertIsDisplayed()
    }

    @Then("All the customers are displayed and scrollable on the screen")
    fun allTheCustomersAreDisplayedAndScrollable() {
        // Check that the first customers are visible
        composeRule.onNodeWithText("Alice Wonderland").assertIsDisplayed()

        // Perform scroll action to verify it is scrollable
        composeRule.onNode(hasScrollAction()) // ensure scrollable container exists
            .performScrollToIndex(4)           // scroll to a later item, e.g., 5th item

        // Now verify the last customer becomes visible
        composeRule.onNodeWithText("Evan Escape").assertIsDisplayed()
    }
}