package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.matcher.ViewMatchers;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.elements.ControlPanelScreen;
import ru.iteco.fmhandroid.ui.elements.NewsScreen;
import ru.iteco.fmhandroid.ui.helpers.MainHelper.TextHelpers;

public class ControlPanelSteps {

    ControlPanelScreen ControlPanelScreen = new ControlPanelScreen();
    NewsScreen NewsScreen = new NewsScreen();

    @Step("Получение даты публикации первой новости")
    public String getFirstNewsPublicationDate() {
        return TextHelpers.getText(ControlPanelScreen.firstPublicationDate);
    }

    @Step("Получение даты создания первой новости")
    public String getFirstNewsCreationDate() {
        return TextHelpers.getText(ControlPanelScreen.firstCreationDate);
    }

    @Step("Получение даты публикации тестовой первой новости")
    public String getFirstNewsPublicationDateAgain() {
        return TextHelpers.getText(ControlPanelScreen.firstPublicationDateAgain);
    }

    @Step("Получение даты создания тестовой первой новости")
    public String getFirstNewsCreationDateAgain() {
        return TextHelpers.getText(ControlPanelScreen.firstCreationDateAgain);
    }

    @Step("Получение даты публикации последней новости")
    public String getLastNewsPublicationDate() {
        return TextHelpers.getText(ControlPanelScreen.lastPublicationDate);
    }

    @Step("Переход к экрану создания новости")
    public void createNews() {
        ControlPanelScreen.createNewsButton.perform(click());
    }

    @Step("Проверка отображение экрана панели управления")
    public void isControlPanel() {
        NewsScreen.controlPanel.check(matches(isDisplayed()));
    }

    @Step("Проверка даты публикации первой новости")
    public void checkFirstPublicationDate(String text) {
        ControlPanelScreen.firstPublicationDate.check(matches(withText(text)));
    }

    @Step("Проверка даты публикации первой не активной новости")
    public void checkFirstPublicationDateNotActive(String text) {
        ControlPanelScreen.firstPublicationDateNotActive.check(matches(withText(text)));
    }

    @Step("Проверка даты публикации первой активной новости")
    public void checkFirstPublicationDateActive(String text) {
        ControlPanelScreen.firstPublicationDateActive.check(matches(withText(text)));
    }

    @Step("Проверка статуса новости")
    public void checkNewsStatus() {
        ControlPanelScreen.newsStatus.check(matches(withText("Not active")));
    }

    @Step("Проверка статуса активной новости")
    public void checkNewsStatusActive() {
        ControlPanelScreen.newsStatusActive.check(matches(withText("Active")));
    }

    @Step("Открытие окна редактирования новости")
    public void clickEditNews() {
        ControlPanelScreen.editNewsButton.perform(click());
    }

    @Step("Открытие окна изменения выбранной новости")
    public void clickEditThisNews() {
        ControlPanelScreen.newsEdit.perform(click());
    }

    @Step("Проверка статуса не активной новости")
    public void checkNewsStatusNotActive() {
        ControlPanelScreen.buttonEditNewsNotActive.perform(click());
    }

    @Step("Удаление новости")
    public void clickDeleteNews() {
        ControlPanelScreen.buttonDeleteNews.perform(click());
    }

    @Step("Удаление выбранной новости")
    public void clickDeleteThisNews() {
        ControlPanelScreen.newsDelete.perform(click());
    }

    @Step("Нажатие на заголовок")
    public void clickNewsTitle() {
        ControlPanelScreen.newsTitle.perform(click());
    }

    @Step("Проверка описания новости")
    public void checkNewsDescription(boolean visible) {
        if (visible) {
            ControlPanelScreen.newsDescription.check(matches(isDisplayed()));
        } else {
            ControlPanelScreen.newsDescription.check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)));
        }
    }
}
