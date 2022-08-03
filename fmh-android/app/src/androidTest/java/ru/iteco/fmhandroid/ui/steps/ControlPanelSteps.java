package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.elements.ControlPanelScreen;
import ru.iteco.fmhandroid.ui.elements.NewsScreen;
import ru.iteco.fmhandroid.ui.helpers.MainHelper.TextHelpers;

public class ControlPanelSteps {

    ControlPanelScreen ControlPanelScreen = new ControlPanelScreen();
    NewsScreen NewsScreen = new NewsScreen();

    public String getFirstNewsPublicationDate() {
        Allure.step("Получение даты публикации первой новости");
        return TextHelpers.getText(ControlPanelScreen.firstPublicationDate);
    }

    public String getFirstNewsCreationDate() {
        Allure.step("Получение даты создания первой новости");
        return TextHelpers.getText(ControlPanelScreen.firstCreationDate);
    }

    public String getFirstNewsPublicationDateAgain() {
        Allure.step("Получение даты публикации тестовой первой новости");
        return TextHelpers.getText(ControlPanelScreen.firstPublicationDateAgain);
    }

    public String getFirstNewsCreationDateAgain() {
        Allure.step("Получение даты создания тестовой первой новости");
        return TextHelpers.getText(ControlPanelScreen.firstCreationDateAgain);
    }

    public String getLastNewsPublicationDate() {
        Allure.step("Получение даты публикации последней новости");
        return TextHelpers.getText(ControlPanelScreen.lastPublicationDate);
    }

    public void createNews() {
        Allure.step("Переход к экрану создания новости");
        ControlPanelScreen.createNewsButton.perform(click());
    }

    public void isControlPanel() {
        Allure.step("Проверка отображение экрана панели управления");
        NewsScreen.controlPanel.check(matches(isDisplayed()));
    }

    public void checkFirstPublicationDate(String text) {
        Allure.step("Проверка даты публикации первой новости");
        ControlPanelScreen.firstPublicationDate.check(matches(withText(text)));
    }

    public void checkFirstPublicationDateNotActive(String text) {
        Allure.step("Проверка даты публикации первой не активной новости");
        ControlPanelScreen.firstPublicationDateNotActive.check(matches(withText(text)));
    }

    public void checkFirstPublicationDateActive(String text) {
        Allure.step("Проверка даты публикации первой активной новости");
        ControlPanelScreen.firstPublicationDateActive.check(matches(withText(text)));
    }

    public void checkNewsStatus() {
        Allure.step("Проверка статуса новости");
        ControlPanelScreen.newsStatus.check(matches(withText("Not active")));
    }

    public void checkNewsStatusActive() {
        Allure.step("Проверка статуса активной новости");
        ControlPanelScreen.newsStatusActive.check(matches(withText("Active")));
    }

    public void clickEditNews() {
        Allure.step("Открытие окна редактирования новости");
        ControlPanelScreen.editNewsButton.perform(click());
    }

    public void clickEditThisNews() {
        Allure.step("Открытие окна изменения выбранной новости");
        ControlPanelScreen.newsEdit.perform(click());
    }

    public void checkNewsStatusNotActive() {
        Allure.step("Проверка статуса не активной новости");
        ControlPanelScreen.buttonEditNewsNotActive.perform(click());
    }

    public void clickDeleteNews() {
        Allure.step("Удаление новости");
        ControlPanelScreen.buttonDeleteNews.perform(click());
    }

    public void clickDeleteThisNews() {
        Allure.step("Удаление выбранной новости");
        ControlPanelScreen.newsDelete.perform(click());
    }
}
