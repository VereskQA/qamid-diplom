package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.elements.OverallElements;

public class OverallSteps {

    OverallElements OverallElements = new OverallElements();

    @Step("Кликнуть выйти из приложения")
    public void logout() {
        OverallElements.portraitImage.perform(click());
        OverallElements.logoutButton.perform(click());
    }
}