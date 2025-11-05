package com.kirabium.relayance.cucumber.steps

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.kirabium.relayance.di.ComposeRuleHolder
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When

class DetailSteps (private val composeRuleHolder: ComposeRuleHolder) {

    private val composeRule: ComposeTestRule = composeRuleHolder.composeRule


}