package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isChecked;
import static androidx.test.espresso.matcher.ViewMatchers.isNotChecked;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.elements.NewsFilterScreen;

public class NewsFilterSteps {

    NewsFilterScreen NewsFilterScreen = new NewsFilterScreen();

    public void enterPublishDateStart(String text) {
        Allure.step("Ввод начальной даты публикации");
        NewsFilterScreen.publishDateStart.perform(replaceText(text));
    }

    public void enterPublishDateEnd(String text) {
        Allure.step("Ввод конечной даты публикации");
        NewsFilterScreen.publishDateEnd.perform(replaceText(text));
    }

    public void clickFilter() {
        Allure.step("Фильтрация");
        NewsFilterScreen.buttonFilter.perform(click());
    }

    public void clickCheckboxActive() {
        Allure.step("Установка чекбокса \"Активные\"");
        NewsFilterScreen.checkboxActive.perform(click());
    }

    public void clickCheckboxNotActive() {
        Allure.step("Установка чекбокса Не активные\"");
        NewsFilterScreen.checkboxNotActive.perform(click());
    }

    public void checkCheckboxActive(boolean checked) {
        Allure.step("Проверка чекбокса \"Активные\"");
        if (checked) {
            NewsFilterScreen.checkboxActive.check(matches(isChecked()));
        } else {
            NewsFilterScreen.checkboxActive.check(matches(isNotChecked()));
        }
    }

    public void checkCheckboxNotActive(boolean checked) {
        Allure.step("Проверка чекбокса \"Не активные\"");
        if (checked) {
            NewsFilterScreen.checkboxNotActive.check(matches(isChecked()));
        } else {
            NewsFilterScreen.checkboxNotActive.check(matches(isNotChecked()));
        }
    }
}
