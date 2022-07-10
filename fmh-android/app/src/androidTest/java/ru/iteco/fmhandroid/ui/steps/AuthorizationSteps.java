package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import ru.iteco.fmhandroid.ui.elements.AuthorizationScreen;

public class AuthorizationSteps {
    AuthorizationScreen AuthorizationScreen = new AuthorizationScreen();

    public void isAuthorizationScreen() {
        AuthorizationScreen.label.check(matches(isDisplayed()));
    }

    public void enterLogin(String text) {
        AuthorizationScreen.login.check(matches(isEnabled()));
        AuthorizationScreen.login.perform(replaceText(text));
    }

    public void enterPassword(String text) {
        AuthorizationScreen.password.check(matches(isEnabled()));
        AuthorizationScreen.password.perform(replaceText(text));
    }

    public void clickSignInButton() {
        AuthorizationScreen.signInButton.check(matches(isClickable()));
        AuthorizationScreen.signInButton.perform(click());
    }
}

