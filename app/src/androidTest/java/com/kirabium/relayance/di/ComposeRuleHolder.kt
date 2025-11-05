package com.kirabium.relayance.di

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.kirabium.relayance.MainActivity
import io.cucumber.junit.WithJunitRule
import org.junit.Rule

@WithJunitRule
class ComposeRuleHolder {
    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()
}