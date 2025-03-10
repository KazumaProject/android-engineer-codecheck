package jp.co.yumemi.android.code_check

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.PerformException
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.espresso.util.HumanReadables
import androidx.test.espresso.util.TreeIterables
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.hamcrest.Matcher
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.concurrent.TimeoutException

@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
@LargeTest
class TopActivityTest {

    @get:Rule
    var mActivityScenarioRule = ActivityScenarioRule(TopActivity::class.java)

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Before
    fun init() {
        hiltRule.inject()
    }

    @Test
    fun topActivityTest() {
        onView(isRoot()).perform(waitForView(withId(R.id.searchInputText), 5000))
        onView(withId(R.id.searchInputText)).perform(replaceText("My"), closeSoftKeyboard())
        onView(withId(R.id.searchInputText)).perform(pressImeActionButton())
        onView(withId(R.id.recyclerView)).perform(waitForRecyclerViewItemCount(1, 5000))
        onView(withId(R.id.recyclerView)).perform(
            actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.nameView)).check(matches(withText("MyTestRepo")))
        onView(withId(R.id.languageView)).check(matches(withText("Kotlin")))
        onView(withId(R.id.starsView)).check(matches(withText("42 stars")))
        onView(withId(R.id.watchersView)).check(matches(withText("42 watchers")))
        onView(withId(R.id.forksView)).check(matches(withText("10 forks")))
        onView(withId(R.id.openIssuesView)).check(matches(withText("5 open issues")))
    }

    private fun waitForView(viewMatcher: Matcher<View>, timeout: Long): ViewAction {
        return object : ViewAction {
            override fun getConstraints(): Matcher<View> = isRoot()

            override fun getDescription(): String =
                "wait for a view matching $viewMatcher for $timeout milliseconds."

            override fun perform(uiController: UiController, view: View) {
                val endTime = System.currentTimeMillis() + timeout
                do {
                    for (child in TreeIterables.breadthFirstViewTraversal(view)) {
                        if (viewMatcher.matches(child)) {
                            return
                        }
                    }
                    uiController.loopMainThreadForAtLeast(50)
                } while (System.currentTimeMillis() < endTime)
                throw PerformException.Builder().withActionDescription(this.description)
                    .withViewDescription(HumanReadables.describe(view))
                    .withCause(TimeoutException("View not found within $timeout milliseconds."))
                    .build()
            }
        }
    }

    private fun waitForRecyclerViewItemCount(minItemCount: Int, timeout: Long): ViewAction {
        return object : ViewAction {
            override fun getConstraints(): Matcher<View> =
                isAssignableFrom(RecyclerView::class.java)

            override fun getDescription(): String =
                "Wait for RecyclerView to have at least $minItemCount items."

            override fun perform(uiController: UiController, view: View) {
                val recyclerView = view as RecyclerView
                val endTime = System.currentTimeMillis() + timeout
                do {
                    if (recyclerView.adapter != null && recyclerView.adapter!!.itemCount >= minItemCount) {
                        return
                    }
                    uiController.loopMainThreadForAtLeast(50)
                } while (System.currentTimeMillis() < endTime)
                throw PerformException.Builder().withActionDescription(this.description)
                    .withViewDescription(HumanReadables.describe(view)).withCause(
                        TimeoutException(
                            "RecyclerView did not have at least $minItemCount items within $timeout milliseconds."
                        )
                    ).build()
            }
        }
    }
}
