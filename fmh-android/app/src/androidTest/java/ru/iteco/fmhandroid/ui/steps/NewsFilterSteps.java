package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isChecked;
import static androidx.test.espresso.matcher.ViewMatchers.isNotChecked;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.elements.NewsFilterScreen;

public class NewsFilterSteps {

    NewsFilterScreen NewsFilterScreen = new NewsFilterScreen();

    @Step("Ввод начальной даты публикации")
    public void enterPublishDateStart(String text) {
        NewsFilterScreen.publishDateStart.perform(replaceText(text));
    }

    @Step("Ввод конечной даты публикации")
    public void enterPublishDateEnd(String text) {
        NewsFilterScreen.publishDateEnd.perform(replaceText(text));
    }

    @Step("Фильтрация")
    public void clickFilter() {
        NewsFilterScreen.buttonFilter.perform(click());
    }

    @Step("Установка чекбокса \"Активные\"")
    public void clickCheckboxActive() {
        NewsFilterScreen.checkboxActive.perform(click());
    }

    @Step("Установка чекбокса Не активные\"")
    public void clickCheckboxNotActive() {
        NewsFilterScreen.checkboxNotActive.perform(click());
    }

    @Step("Проверка чекбокса \"Активные\"")
    public void checkCheckboxActive(boolean checked) {
        if (checked) {
            NewsFilterScreen.checkboxActive.check(matches(isChecked()));
        } else {
            NewsFilterScreen.checkboxActive.check(matches(isNotChecked()));
        }
    }

    @Step("Проверка чекбокса \"Не активные\"")
    public void checkCheckboxNotActive(boolean checked) {
        if (checked) {
            NewsFilterScreen.checkboxNotActive.check(matches(isChecked()));
        } else {
            NewsFilterScreen.checkboxNotActive.check(matches(isNotChecked()));
        }
    }
}
