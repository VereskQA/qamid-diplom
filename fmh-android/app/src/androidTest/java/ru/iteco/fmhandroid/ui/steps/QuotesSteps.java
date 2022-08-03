package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.allOf;

import android.os.SystemClock;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.elements.QuotesScreen;

public class QuotesSteps {

    QuotesScreen QuotesScreen = new QuotesScreen();

    public void checkAll() {
        Allure.step("Проверить всё");
        QuotesScreen.titleText.check(matches(allOf(withText("Love is all"), isDisplayed())));
        QuotesScreen.image.check(matches(isDisplayed()));
        QuotesScreen.quoteTitle.check(matches(isDisplayed()));
    }

    public void expandQuote() {
        Allure.step("Развернуть цитату");
        QuotesScreen.quoteTitleClickable.perform(click());
        QuotesScreen.quoteDescription.check(matches(isDisplayed()));
    }

    public void collapseQuote() {
        Allure.step("Свернуть цитату");
        QuotesScreen.quoteTitleClickable2.perform(click());
        SystemClock.sleep(1000);
        QuotesScreen.quoteDescriptionAfterClick.check(doesNotExist());
    }
}
