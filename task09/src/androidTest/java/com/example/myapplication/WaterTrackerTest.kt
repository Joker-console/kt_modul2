package com.example.myapplication

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class WaterTrackerTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun addWaterButtonTest() {
        composeTestRule
            .onNodeWithText("+250 мл")
            .assertIsDisplayed()
            .performClick()

        composeTestRule
            .onNodeWithText("350 мл")
            .assertIsDisplayed()
    }

    @Test
    fun finishDayButtonTest() {
        composeTestRule
            .onNodeWithText("+250 мл")
            .performClick()

        composeTestRule
            .onNodeWithText("Завершить день")
            .assertIsDisplayed()
            .performClick()

        composeTestRule
            .onNodeWithText("0 мл")
            .assertIsDisplayed()
    }

    @Test
    fun consecutiveDaysTextTest() {
        composeTestRule
            .onNodeWithText("Дней подряд с 1500 мл и больше: 0")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("Завершить день")
            .performClick()

        repeat(2) { day ->
            repeat(6) {
                composeTestRule
                    .onNodeWithText("+250 мл")
                    .performClick()
            }

            composeTestRule
                .onNodeWithText("Завершить день")
                .performClick()

            composeTestRule
                .onNodeWithText(
                    "Дней подряд с 1500 мл и больше: ${day + 1}"
                )
                .assertIsDisplayed()
        }

        repeat(5) {
            composeTestRule
                .onNodeWithText("+250 мл")
                .performClick()
        }

        composeTestRule
            .onNodeWithText("Завершить день")
            .performClick()

        composeTestRule
            .onNodeWithText("Дней подряд с 1500 мл и больше: 0")
            .assertIsDisplayed()
    }
}
