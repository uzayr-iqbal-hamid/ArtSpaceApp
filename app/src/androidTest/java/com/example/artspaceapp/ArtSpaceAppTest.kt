package com.example.artspaceapp

import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.text.AnnotatedString
import org.junit.Rule
import org.junit.Test

class ArtSpaceAppTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun nextButton_changeArtwork() {

        composeTestRule
            .onNodeWithText("ArtworkTitle")
            .assertExists()

        val initialTitle = composeTestRule
            .onNodeWithText("ArtworkTitle")
            .fetchSemanticsNode()
            .config[SemanticsProperties.Text]
            .first()
            .text

        composeTestRule
            .onNodeWithText("NextButton")
            .performClick()

        composeTestRule
            .onNodeWithText("ArtworkTitle")
            .assert(
                SemanticsMatcher.expectValue(
                    SemanticsProperties.Text,
                    listOf(AnnotatedString(initialTitle))
                ).not()
            )
    }
}