package com.kirabium.relayance.di

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.kirabium.relayance.MainActivity
import com.oliviermarteaux.shared.test.di.ComposeRuleHolderInterface
import io.cucumber.junit.WithJunitRule
import org.junit.Rule

@WithJunitRule
class ComposeRuleHolder : ComposeRuleHolderInterface {
    @get:Rule
    override val composeRule = createAndroidComposeRule<MainActivity>()
}