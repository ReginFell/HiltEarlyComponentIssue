package com.regin.earlycomponentissue

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import dagger.hilt.android.testing.BindValue
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest

import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule

@HiltAndroidTest
class HiltEarlyComponentIssueTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @BindValue
    val test2 = "Hello2"

    @Test
    fun runTest() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.regin.earlycomponentissue", appContext.packageName)
    }
}