package net.practicalcoding.scientificcalculator;

import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


public class EmTests {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void simpleAdditionTest() {
        onView(withId(R.id.button19)).perform(click());
        onView(withId(R.id.button16)).perform(click());
        onView(withId(R.id.button10)).perform(click());
        onView(withId(R.id.button20)).perform(click());
        onView(withId(R.id.previousCalculationView)).check(matches(withText("1+8")));
        onView(withId(R.id.displayEditText)).check(matches(withText("9.0")));
    }

    @Test
    public void ErasingTest() {
        onView(withId(R.id.button13)).perform(click());
        onView(withId(R.id.button9)).perform(click());
        onView(withId(R.id.button7)).perform(click());
        onView(withId(R.id.previousCalculationView)).check(matches(withText("")));
        onView(withId(R.id.displayEditText)).check(matches(withText("")));
    }

    @Test
    public void complicatedMultiTest() {
        onView(withId(R.id.button9)).perform(click());
        onView(withId(R.id.button10)).perform(click());
        onView(withId(R.id.button8)).perform(click());
        onView(withId(R.id.button17)).perform(click());
        onView(withId(R.id.button18)).perform(click());
        onView(withId(R.id.button20)).perform(click());
        onView(withId(R.id.previousCalculationView)).check(matches(withText("98×32")));
        onView(withId(R.id.displayEditText)).check(matches(withText("3136.0")));
    }

    @Test
    public void NaNTest() {
        onView(withId(R.id.button5)).perform(click());
        onView(withId(R.id.button5)).perform(click());
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.button5)).perform(click());
        onView(withId(R.id.button20)).perform(click());
        onView(withId(R.id.previousCalculationView)).check(matches(withText("))0)")));
        onView(withId(R.id.displayEditText)).check(matches(withText("NaN")));
    }

    @Test
    public void cancelTest() {
        onView(withId(R.id.button10)).perform(click());
        onView(withId(R.id.button4)).perform(click());
        onView(withId(R.id.button11)).perform(click());
        onView(withId(R.id.button3)).perform(click());
        onView(withId(R.id.button17)).perform(click());
        onView(withId(R.id.button20)).perform(click());
        onView(withId(R.id.previousCalculationView)).check(matches(withText("8÷3")));
        onView(withId(R.id.displayEditText)).check(matches(withText("2.6666666666666665")));
    }

    @Test
    public void bracketsTest() {
        onView(withId(R.id.button6)).perform(click());
        onView(withId(R.id.button9)).perform(click());
        onView(withId(R.id.button16)).perform(click());
        onView(withId(R.id.button17)).perform(click());
        onView(withId(R.id.button5)).perform(click());
        onView(withId(R.id.button8)).perform(click());
        onView(withId(R.id.button18)).perform(click());
        onView(withId(R.id.button20)).perform(click());
        onView(withId(R.id.previousCalculationView)).check(matches(withText("(9+3)×2")));
        onView(withId(R.id.displayEditText)).check(matches(withText("24.0")));
    }
}