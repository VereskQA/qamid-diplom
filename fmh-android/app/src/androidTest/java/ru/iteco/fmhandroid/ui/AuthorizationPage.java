package ru.iteco.fmhandroid.ui;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import android.os.SystemClock;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;
import ru.iteco.fmhandroid.ui.steps.OverallSteps;

@RunWith(AllureAndroidJUnit4.class)
public class AuthorizationPage {

    AuthorizationSteps AuthorizationSteps = new AuthorizationSteps();
    MainSteps MainSteps = new MainSteps();
    OverallSteps OverallSteps = new OverallSteps();

    @Rule
    public ActivityTestRule<AppActivity> mActivityTestRule = new ActivityTestRule<>(AppActivity.class);

    @Before
    public void logoutCheck() {
        SystemClock.sleep(6000);
        try {
            AuthorizationSteps.isAuthorizationScreen();
        } catch (NoMatchingViewException e) {
            OverallSteps.logout();
        }
    }

    @Test
    @DisplayName("Проверка логина без заполнения формы")
    public void signInEmpty() {
        AuthorizationSteps.isAuthorizationScreen();
        AuthorizationSteps.clickSignInButton();
        onView(withText(R.string.empty_login_or_password))
                .inRoot(withDecorView(not(is(mActivityTestRule.getActivity().getWindow()
                        .getDecorView())))).check(matches(withText("Login and password cannot be empty")));
    }

    @Test
    @DisplayName("Проверка логина невалидными данными")
    public void signInFail() {
        AuthorizationSteps.isAuthorizationScreen();
        AuthorizationSteps.enterLogin("login");
        AuthorizationSteps.checkEnterLogin("login");
        AuthorizationSteps.enterPassword("pass");
        AuthorizationSteps.checkEnterPassword("pass");
        AuthorizationSteps.clickSignInButton();
        onView(withText(R.string.wrong_login_or_password))
                .inRoot(withDecorView(not(is(mActivityTestRule.getActivity().getWindow()
                        .getDecorView())))).check(matches(withText("Wrong login or password")));
    }

    @Test
    @DisplayName("Успешный вход за пользователя и выход из приложения")
    public void signInSuccess() {
        AuthorizationSteps.isAuthorizationScreen();
        AuthorizationSteps.enterLogin("login2");
        AuthorizationSteps.checkEnterLogin("login2");
        AuthorizationSteps.enterPassword("password2");
        AuthorizationSteps.checkEnterPassword("password2");
        AuthorizationSteps.clickSignInButton();
        SystemClock.sleep(2500);
        MainSteps.isMainScreen();
        OverallSteps.logout();
    }
}
