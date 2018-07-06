package com.example.tnis.tngpworldcup.ui

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.example.tnis.tngpworldcup.R
import org.hamcrest.CoreMatchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    val rule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun checkMainActivityDisplayComponents() {
        onView(withId(R.id.img_fullscreen_background)).check(matches(isDisplayed()))
        onView(withId(R.id.img_world_cup_trophy)).check(matches(isDisplayed()))
        onView(withId(R.id.text_world_cup_date)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_play))
                .check(matches(isDisplayed()))
                .check(matches(isClickable()))
        onView(withId(R.id.progress_bar)).check(matches(not(isDisplayed())))
    }

    @Test
    fun checkMainActivityShowProgressBar() {
        onView(withId(R.id.img_fullscreen_background)).check(matches(isDisplayed()))
        onView(withId(R.id.img_world_cup_trophy)).check(matches(isDisplayed()))
        onView(withId(R.id.text_world_cup_date)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_play)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_play)).perform(ViewActions.click())
        onView(withId(R.id.progress_bar)).check(matches(isDisplayed()))
    }

}