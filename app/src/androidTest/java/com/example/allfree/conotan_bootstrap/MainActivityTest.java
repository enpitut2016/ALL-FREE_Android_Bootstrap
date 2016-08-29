package com.example.allfree.conotan_bootstrap;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

/**
 * Created by tsuruda_tomohiro on 2016/08/29.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity mActivity;

    public MainActivityTest() {
        super(MainActivity.class);
    }
    @Before
    public void setUp() throws Exception {
        super.setUp();
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        mActivity = getActivity();
    }
    @Test
    public void testSendHelp() {
        onView(withId(R.id.parent)).perform(click());
        onView(withId(R.id.send_text)).perform(typeText("testhoge"));
        onView(withId(R.id.send)).perform(click());
        onView(withId(R.id.help_text)).check(matches(withText("testhoge")));
        mActivity.finish();
    }
    @Test
    public void testShowManual() {
        onView(withId(R.id.manual)).perform(click());
        /*
        onData(allOf(is(instanceOf(String.class)), is("text")))
                .inAdapterView(withId(android.R.layout.simple_list_item_1))
                .atPosition(3)
                .perform(click());
        */
        onData(anything()).inAdapterView(withId(R.id.listView))
                .atPosition(0)
                .perform(click());
        onView(withId(R.id.manualtitle)).check(matches(withText("LINEのスタンプの使い方教えて！")));
        mActivity.finish();
    }
}
