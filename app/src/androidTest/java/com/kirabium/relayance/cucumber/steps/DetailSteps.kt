package com.kirabium.relayance.cucumber.steps

import androidx.compose.ui.test.junit4.ComposeTestRule
import com.kirabium.relayance.di.ComposeRuleHolder
import com.oliviermarteaux.shared.test.di.ComposeRuleHolderInterface

class DetailSteps (private val composeRuleHolder: ComposeRuleHolderInterface) {

    private val composeRule: ComposeTestRule = composeRuleHolder.composeRule


}