package com.kirabium.relayance.cucumber.steps

import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.hasClickAction
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

    @Given("I am on the Home screen")
    @Then("I should return to the Home screen")
    fun iAmOnTheHomeScreen() {
        composeRule.onNodeWithText("Alice Wonderland").assertIsDisplayed()
        composeRule.onNodeWithText("Bob Builder").assertIsDisplayed()
        composeRule.onNodeWithText("Charlie Chocolate").assertIsDisplayed()
        composeRule.onNodeWithText("Diana Dream").assertIsDisplayed()
        composeRule.onNodeWithText("Evan Escape").assertIsDisplayed()
    }

    @When("I click on the {string} FAB button")
    fun iClickOnButton(fabLabel: String) {
        // Use contentDescription or tag for your FABs
        composeRule.onNodeWithContentDescription(fabLabel).performClick()
    }

    @Then("I should arrive on the Add screen")
    @Given("I am on the Add screen")
    fun iAmOnTheAddScreen() {
        composeRule.onNodeWithText("name").assertIsDisplayed()
        composeRule.onNodeWithText("email").assertIsDisplayed()
    }

    @When("I enter {string} in the {string} field")
    fun iEnterText(name:String, textFieldLabel: String) {
        composeRule.onNodeWithText(textFieldLabel).performTextInput(name)
    }

    @And("I should see {string} added at the end of the customer list")
    fun iShouldSeeTextInLastListItem(text: String){
        composeRule.onNodeWithText(text).assertIsDisplayed()
        val customerNodes = composeRule.onAllNodes(hasClickAction())
        val lastCustomerNode = customerNodes[customerNodes.fetchSemanticsNodes().size - 2]
        lastCustomerNode.assertTextContains(text)
    }

    @And("I should see a toast message {string}")
    fun iShouldSeeText(text: String) {
        composeRule.onNodeWithText(text).assertIsDisplayed()
    }

    @Then("I cannot click on the {string} FAB button")
    fun iCannotClickButton(buttonLabel:String){
        composeRule.onNodeWithContentDescription(buttonLabel).assert(hasClickAction())
    }
}