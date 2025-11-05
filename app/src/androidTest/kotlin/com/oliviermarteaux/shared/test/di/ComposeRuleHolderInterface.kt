package com.oliviermarteaux.shared.test.di

import androidx.compose.ui.test.junit4.AndroidComposeTestRule

interface ComposeRuleHolderInterface {
    val composeRule: AndroidComposeTestRule<*,*>
}