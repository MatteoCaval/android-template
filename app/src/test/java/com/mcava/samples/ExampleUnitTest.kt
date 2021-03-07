package com.mcava.samples

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    fun logDeeplinkEvent(eventName: String?, keyValueParams: Map<String, String>) {
        val fullEventName =  eventName?.let { "lp_function_action_$it" } ?: "lp_function_action"

    }
}