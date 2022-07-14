package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.elements.MainScreen;

public class MainSteps {
    ru.iteco.fmhandroid.ui.elements.MainScreen MainScreen = new MainScreen();

    @Step("Проверка отображения главного экрана")
    public void isMainScreen() {
        MainScreen.allNewsLink.check(matches(isDisplayed()));
        MainScreen.newsLabel.check(matches(withText("News")));
    }
}
