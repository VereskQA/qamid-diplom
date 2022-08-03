package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.elements.NewsScreen;
import ru.iteco.fmhandroid.ui.helpers.MainHelper;

public class NewsSteps {

    NewsScreen NewsScreen = new NewsScreen();

    public void isNewsScreen() {
        Allure.step("Проверка отображения экрана новостей");
        NewsScreen.news.check(matches(isDisplayed()));
        NewsScreen.buttonSort.check(matches(isDisplayed()));
    }

    public String getFirstNewsTitle() {
        Allure.step("Получение названия первой новости");
        return MainHelper.TextHelpers.getText(NewsScreen.firstNews);
    }

    public String getLastNewsTitle() {
        Allure.step("Получение названия последней новости");
        return MainHelper.TextHelpers.getText(NewsScreen.lastNews);
    }

    public String getFirstNewsAgainTitle() {
        Allure.step("Получение названия новой первой новости");
        return MainHelper.TextHelpers.getText(NewsScreen.firstNewsAgain);
    }

    public void clickSortButton() {
        Allure.step("Сортировка");
        NewsScreen.buttonSort.perform(click());
    }

    public void goToControlPanel() {
        Allure.step("Переход в панель управления");
        NewsScreen.buttonControlPanel.perform(click());
        NewsScreen.controlPanel.check(matches(isDisplayed()));
    }

    public void openFilter() {
        Allure.step("Открытие фильтра");
        NewsScreen.buttonFilter.perform(click());
    }

    public void checkFirstNewsDate(String text) {
        Allure.step("Проверка даты первой новости");
        NewsScreen.firstNewsDate.check(matches(withText(text)));
    }

    public String getLastNewsAgainTitle() {
        Allure.step("Получение названия новой последней новости");
        return MainHelper.TextHelpers.getText(NewsScreen.lastNewsAgain);
    }
}
