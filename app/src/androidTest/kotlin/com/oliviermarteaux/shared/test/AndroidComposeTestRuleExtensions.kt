package com.oliviermarteaux.shared.test

import androidx.activity.ComponentActivity
import androidx.annotation.StringRes
import androidx.compose.ui.test.SemanticsNodeInteraction
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.rules.ActivityScenarioRule

fun <A : ComponentActivity> AndroidComposeTestRule<ActivityScenarioRule<A>, A>.onNodeWithStringId(
    @StringRes id: Int, param: String? = null, useUnmergedTree: Boolean = true
): SemanticsNodeInteraction = onNodeWithText(
    text = activity.getString(id, param),
    useUnmergedTree = useUnmergedTree
)