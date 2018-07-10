package com.example.tnis.tngpworldcup.ui

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.swipeUp
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView
import com.example.tnis.tngpworldcup.R
import org.hamcrest.CoreMatchers.not
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.concurrent.thread


@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    val rule = ActivityTestRule(MainActivity::class.java)



    @Test
    fun checkMainActivityToDetailPage() {
        onView(withId(R.id.img_fullscreen_background)).check(matches(isDisplayed()))
        onView(withId(R.id.img_world_cup_trophy)).check(matches(isDisplayed()))
        onView(withId(R.id.text_world_cup_date)).check(matches(isDisplayed()))
        Thread.sleep(2000)
        onView(withId(R.id.btn_play)).check(matches(isDisplayed()))
        Thread.sleep(2000)
        onView(withId(R.id.btn_play)).perform(ViewActions.click())
        Thread.sleep(8000)

        onView(withId(R.id.list_football_matches))
                .perform(swipeUp())

        Thread.sleep(3000)

        onView(withId(R.id.list_football_matches))
                .perform(actionOnItemAtPosition<RecyclerView.ViewHolder>(6, click() ))

        Thread.sleep(2000)

        onView(withId(R.id.text_group_name)).check(matches(isDisplayed()))
    }

}