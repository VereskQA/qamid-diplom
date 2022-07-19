package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.os.SystemClock;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.elements.CreateClaimScreen;

public class CreateClaimSteps {

    CreateClaimScreen CreateClaimScreen = new CreateClaimScreen();

    @Step("Проверка отображения экрана создания заявки")
    public void isCreateClaimsScreen() {
        CreateClaimScreen.title.check(matches(withText("Creating")));
        CreateClaimScreen.subTitle.check(matches(withText("Claims")));
    }

    @Step("Проверка длины заголовка")
    public void checkClaimTitleLength() {
        CreateClaimScreen.claimTitle.perform(replaceText("Очень большой заголовок, самый большой заголовок на планете"));
        CreateClaimScreen.claimTitle.check(matches(withText("Очень большой заголовок, самый большой заголовок н")));
    }

    @Step("Проверка появления алерта про пустые поля")
    public void checkToastEmptyFields() {
        CreateClaimScreen.emptyFieldsAlert.check(matches(isDisplayed()));
    }

    @Step("Ввод заголововка")
    public void enterClaimTitle(String text) {
        CreateClaimScreen.claimTitle.check(matches(isDisplayed()));
        CreateClaimScreen.claimTitle.perform(replaceText(text));
    }

    @Step("Выбор исполнителя")
    public void selectExecutor() {
        CreateClaimScreen.executorList.perform(click());
        SystemClock.sleep(2000);
        CreateClaimScreen.claimTitle.perform(click(), closeSoftKeyboard());
    }

    @Step("Ввод даты")
    public void enterClaimDate(String text) {
        CreateClaimScreen.claimDate.check(matches(isDisplayed()));
        CreateClaimScreen.claimDate.perform(replaceText(text));
    }

    @Step("Ввод времени")
    public void enterClaimTime(String text) {
        CreateClaimScreen.claimTime.check(matches(isDisplayed()));
        CreateClaimScreen.claimTime.perform(replaceText(text));
    }

    @Step("Ввод описания")
    public void enterClaimDescription(String text) {
        CreateClaimScreen.claimDescription.check(matches(isDisplayed()));
        CreateClaimScreen.claimDescription.perform(replaceText(text), closeSoftKeyboard());
    }
}
