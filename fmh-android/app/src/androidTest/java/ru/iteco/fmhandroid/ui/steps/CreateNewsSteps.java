package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.elements.CreateNewsScreen;

public class CreateNewsSteps {

    CreateNewsScreen CreateNewsScreen = new CreateNewsScreen();

    @Step("Проверка отображения экрана создания новости")
    public void isCreateNewsScreen() {
        CreateNewsScreen.title.check(matches(withText("Creating")));
        CreateNewsScreen.subTitle.check(matches(withText("News")));
    }

    @Step("Проверка отображения экрана редактирования новости")
    public void isEditNewsScreen() {
        CreateNewsScreen.title.check(matches(withText("Editing")));
        CreateNewsScreen.subTitle.check(matches(withText("News")));
    }

    @Step("Выбор категории новости")
    public void selectNewsCategory() {
        CreateNewsScreen.categoryList.perform(click());
        CreateNewsScreen.newsTitle.perform(click());
    }

    @Step("Ввод заголовка")
    public void enterNewsTitle(String text) {
        CreateNewsScreen.newsTitle.perform(replaceText(text), closeSoftKeyboard());
    }

    @Step("Ввод даты публикации")
    public void enterNewsPublicationDate(String text) {
        CreateNewsScreen.newsDate.perform(replaceText(text));
    }

    @Step("Ввод времени")
    public void enterNewsTime(String text) {
        CreateNewsScreen.newsTime.perform(replaceText(text));
    }

    @Step("Ввод описания")
    public void enterNewsDescription(String text) {
        CreateNewsScreen.newsDescription.perform(replaceText(text), closeSoftKeyboard());
    }

    @Step("Проверка заголовка")
    public void checkNewsTitle(String text) {
        CreateNewsScreen.newsTitle.check(matches(withText(text)));
    }

    @Step("Проверка переключателя")
    public void checkNewsSwitcher() {
        CreateNewsScreen.newsSwitcher.check(matches(allOf(withText("Active"), isDisplayed())));
    }

    @Step("Нажатие переключателя")
    public void clickNewsSwitcher() {
        CreateNewsScreen.newsSwitcher.perform(click());
    }
}
