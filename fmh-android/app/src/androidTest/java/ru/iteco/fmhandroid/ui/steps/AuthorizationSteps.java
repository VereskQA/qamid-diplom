package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.elements.AuthorizationScreen;

public class AuthorizationSteps {

    AuthorizationScreen AuthorizationScreen = new AuthorizationScreen();

    @Step("Проверка отображения экрана авторизации")
    public void isAuthorizationScreen() {
        AuthorizationScreen.label.check(matches(isDisplayed()));
    }

    @Step("Ввод логина")
    public void enterLogin(String text) {
        AuthorizationScreen.loginInput.check(matches(isEnabled()));
        AuthorizationScreen.loginInput.perform(replaceText(text));
    }

    @Step("Ввод пароля")
    public void enterPassword(String text) {
        AuthorizationScreen.passwordInput.check(matches(isEnabled()));
        AuthorizationScreen.passwordInput.perform(replaceText(text));
    }

    @Step("Нажатие кнопки входа")
    public void clickSignInButton() {
        AuthorizationScreen.signInButton.check(matches(isClickable()));
        AuthorizationScreen.signInButton.perform(click());
    }
}

