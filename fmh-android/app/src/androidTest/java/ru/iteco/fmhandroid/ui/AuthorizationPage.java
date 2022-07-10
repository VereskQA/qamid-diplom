package ru.iteco.fmhandroid.ui;

import android.os.SystemClock;

import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;

@RunWith(AllureAndroidJUnit4.class)
public class AuthorizationPage {

    AuthorizationSteps AuthorizationSteps = new AuthorizationSteps();

    @Rule
    public ActivityTestRule<AppActivity> mActivityTestRule = new ActivityTestRule<>(AppActivity.class);

    @Before
    public void loaderWait() {
        SystemClock.sleep(7000);
    }

    @Test
    @DisplayName("Проверка логина без заполнения формы")
    public void signInEmpty() {
        AuthorizationSteps.isAuthorizationScreen();
        AuthorizationSteps.clickSignInButton();
        AuthorizationSteps.isAuthorizationScreen();
    }

    @Test
    @DisplayName("Проверка логина невалидными данными")
    public void signInFail() {
        AuthorizationSteps.isAuthorizationScreen();
        AuthorizationSteps.enterLogin("login");
        AuthorizationSteps.enterPassword("pass");
        AuthorizationSteps.clickSignInButton();
        AuthorizationSteps.isAuthorizationScreen();
    }

    @Test
    @DisplayName("Успешный вход за пользователя и выход из приложения")
    public void signInSuccess() {

    }
}
