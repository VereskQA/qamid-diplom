package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.elements.NewsScreen;
import ru.iteco.fmhandroid.ui.helpers.MainHelper;

public class NewsSteps {

    NewsScreen NewsScreen = new NewsScreen();

    @Step("Проверка отображения экрана новостей")
    public void isNewsScreen() {
        NewsScreen.news.check(matches(isDisplayed()));
        NewsScreen.buttonSort.check(matches(isDisplayed()));
    }

    @Step("Получение названия первой новости")
    public String getFirstNewsTitle() {
        return MainHelper.TextHelpers.getText(NewsScreen.firstNews);
    }

    @Step("Получение названия последней новости")
    public String getLastNewsTitle() {
        return MainHelper.TextHelpers.getText(NewsScreen.lastNews);
    }

    @Step("Получение названия новой первой новости")
    public String getFirstNewsAgainTitle() {
        return MainHelper.TextHelpers.getText(NewsScreen.firstNewsAgain);
    }

    @Step("Сортировка")
    public void clickSortButton() {
        NewsScreen.buttonSort.perform(click());
    }

    @Step("Переход в панель управления")
    public void goToControlPanel() {
        NewsScreen.buttonControlPanel.perform(click());
        NewsScreen.controlPanel.check(matches(isDisplayed()));
    }

    @Step("Открытие фильтра")
    public void openFilter() {
        NewsScreen.buttonFilter.perform(click());
    }

    @Step("Проверка даты первой новости")
    public void checkFirstNewsDate(String text) {
        NewsScreen.firstNewsDate.check(matches(withText(text)));
    }
}
