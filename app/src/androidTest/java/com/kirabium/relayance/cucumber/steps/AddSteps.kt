package com.kirabium.relayance.cucumber.steps

import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasClickAction
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.kirabium.relayance.di.ComposeRuleHolder
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then

class AddSteps(private val composeRuleHolder: ComposeRuleHolder) {

    private val composeRule = composeRuleHolder.composeRule

    @Then("I should arrive on the Add screen")
    @Given("I am on the Add screen")
    fun iAmOnTheAddScreen() {
        composeRule.onNodeWithText("name").assertIsDisplayed()
        composeRule.onNodeWithText("email").assertIsDisplayed()
    }

    @Then("I cannot click on the {string} FAB button")
    fun iCannotClickFabButton(buttonLabel:String){
        composeRule.onNodeWithContentDescription(buttonLabel).performClick()
        // Assert that user does not go back to home screen
        composeRule.onNodeWithText("Add a new customer").assertDoesNotExist()
    }
}