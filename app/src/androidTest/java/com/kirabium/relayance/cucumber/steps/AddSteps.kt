package com.kirabium.relayance.cucumber.steps

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import com.kirabium.relayance.MainActivity
import io.cucumber.java.en.And
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import io.cucumber.junit.WithJunitRule
import org.junit.Rule

@WithJunitRule
class AddSteps {

    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()

//    private val composeRule get() = TestContext.composeRule

    @Given("I am on the Home screen")
    fun iAmOnTheHomeScreen() {
        composeRule.onNodeWithText("Alice Wonderland").assertIsDisplayed()
        composeRule.onNodeWithText("Bob Builder").assertIsDisplayed()
        composeRule.onNodeWithText("Charlie Chocolate").assertIsDisplayed()
        composeRule.onNodeWithText("Diana Dream").assertIsDisplayed()
        composeRule.onNodeWithText("Evan Escape").assertIsDisplayed()
    }

    @When("I click on the {string} FAB button")
    fun iClickOnFabButton(fabLabel: String) {
        // Use contentDescription or tag for your FABs
        composeRule.onNodeWithContentDescription(fabLabel).performClick()
    }

    @Then("I should arrive on the Add screen")
    fun iShouldArriveOnTheAddScreen() {
        composeRule.onNodeWithText("name").assertIsDisplayed()
        composeRule.onNodeWithText("email").assertIsDisplayed()
    }

    @When("I enter {string} in the name field")
    fun iEnterName(name: String) {
        composeRule.onNodeWithText("name").performTextInput(name)
    }

    @And("I enter {string} in the email field")
    fun iEnterEmail(email: String) {
        composeRule.onNodeWithText("email").performTextInput(email)
    }

    @And("I click on the save FAB button")
    fun iClickSaveFab() {
        composeRule.onNodeWithContentDescription("Save the new customer").performClick()
    }

    @Then("I should return to the Home screen")
    fun iShouldReturnHome() {
        composeRule.onNodeWithText("Alice Wonderland").assertIsDisplayed()
        composeRule.onNodeWithText("Bob Builder").assertIsDisplayed()
        composeRule.onNodeWithText("Charlie Chocolate").assertIsDisplayed()
        composeRule.onNodeWithText("Diana Dream").assertIsDisplayed()
        composeRule.onNodeWithText("Evan Escape").assertIsDisplayed()
    }
}

//    @When("I leave the name field empty")
//    fun iLeaveNameEmpty() {
//        // Ensure field exists but no input
//        composeRule.onNodeWithTag("name_field").performTextClearance()
//    }
//
//    @When("I leave the email field empty")
//    fun iLeaveEmailEmpty() {
//        composeRule.onNodeWithTag("email_field").performTextClearance()
//    }

//    @Then("I should see {string} added at the end of the customer list")
//    fun iShouldSeeCustomerInList(name: String) {
//        composeRule.onNodeWithText(name).assertIsDisplayed()
//    }
//
//    @Then("I should see a toast message {string}")
//    fun iShouldSeeToastMessage(message: String) {
//        // To test toasts, you’ll need a custom matcher or use Compose testing semantics.
//        // Simplest option: check that a composable with message text appears.
//        composeRule.onNodeWithText(message).assertIsDisplayed()
//    }