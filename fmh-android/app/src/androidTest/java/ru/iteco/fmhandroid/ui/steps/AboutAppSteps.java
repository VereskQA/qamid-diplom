package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.elements.AboutAppScreen;

public class AboutAppSteps {

    AboutAppScreen AboutAppScreen = new AboutAppScreen();

    @Step("Полная проверка информационного экрана")
    public void checkEverythingYouWant() {
        AboutAppScreen.versionTitle.check(matches(allOf(withText("Version:"), isDisplayed())));
        AboutAppScreen.versionValue.check(matches(allOf(withText("1.0.0"), isDisplayed())));
        AboutAppScreen.privacyPolicyValue.check(matches(allOf(withText("https://vhospice.org/#/privacy-policy/"), isDisplayed(), isClickable())));
        AboutAppScreen.termsLabel.check(matches(allOf(withText("Terms of use:"), isDisplayed())));
        AboutAppScreen.termsValue.check(matches(allOf(withText("https://vhospice.org/#/terms-of-use"), isDisplayed(), isClickable())));
        AboutAppScreen.companyLabel.check(matches(allOf(withText("© I-Teco, 2022"), isDisplayed())));
    }

    @Step("Возврат назад")
    public void goBack() {
        AboutAppScreen.backButton.perform(click());
    }
}
