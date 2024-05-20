package com.danotech.musicapp

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test

class PlayFeature {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun displayScreenTitle() {
       composeTestRule.onNodeWithText("PlayLists").assertIsDisplayed()
    }
}