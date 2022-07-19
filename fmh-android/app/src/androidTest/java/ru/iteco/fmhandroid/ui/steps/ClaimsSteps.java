package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isChecked;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isNotChecked;

import android.os.SystemClock;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.elements.ClaimScreen;
import ru.iteco.fmhandroid.ui.elements.MainScreen;

public class ClaimsSteps {

    MainScreen MainScreen = new MainScreen();
    ClaimScreen ClaimScreen = new ClaimScreen();

    @Step("Проверка отображения экрана заявок")
    public void isClaimsScreen() {
        MainScreen.addNewClaimButton.check(matches(isDisplayed()));
        MainScreen.allNewsLink.check(doesNotExist());
    }

    @Step("Открытие фильтра")
    public void openFiltering() {
        ClaimScreen.claimFilterButton.perform(click());
        ClaimScreen.claimFilterTitle.check(matches(isDisplayed()));
    }

    @Step("Установка чекбокса \"В процессе\"")
    public void clickCheckboxInProgress() {
        ClaimScreen.inProgressFilter.perform(click());
    }

    @Step("Установка чекбокса \"Открыт\"")
    public void clickCheckboxOpen() {
        ClaimScreen.open.perform(click());
    }

    @Step("Установка чекбокса \"Выполнен\"")
    public void clickCheckboxExecuted() {
        ClaimScreen.executedFilter.perform(click());
    }

    @Step("Установка чекбокса \"Отменен\"")
    public void clickCheckboxCancelled() {
        ClaimScreen.cancelledFilter.perform(click());
    }

    @Step("Клик \"Отмена\"")
    public void clickCancel() {
        ClaimScreen.cancelButton.perform(click());
    }

    @Step("Клик \"ОК\"")
    public void clickOK() {
        ClaimScreen.okButton.perform(click());
    }

    @Step("Проверка чекбокса \"В процессе\"")
    public void checkCheckboxInProgress(boolean checked) {
        if (checked) {
            ClaimScreen.inProgressFilter.check(matches(isChecked()));
        } else {
            ClaimScreen.inProgressFilter.check(matches(isNotChecked()));
        }
    }

    @Step("Проверка чекбокса \"Открыт\"")
    public void checkCheckboxOpen(boolean checked) {
        if (checked) {
            ClaimScreen.open.check(matches(isChecked()));
        } else {
            ClaimScreen.open.check(matches(isNotChecked()));
        }
    }

    @Step("Проверка чекбокса \"Выполнен\"")
    public void checkCheckboxExecuted(boolean checked) {
        if (checked) {
            ClaimScreen.executedFilter.check(matches(isChecked()));
        } else {
            ClaimScreen.executedFilter.check(matches(isNotChecked()));
        }
    }

    @Step("Проверка чекбокса \"Отменен\"")
    public void checkCheckboxCancelled(boolean checked) {
        if (checked) {
            ClaimScreen.cancelledFilter.check(matches(isChecked()));
        } else {
            ClaimScreen.cancelledFilter.check(matches(isNotChecked()));
        }
    }

    @Step("Клик для создания заявки")
    public void createClaim() {
        ClaimScreen.addNewClaimButton.perform(click());
        SystemClock.sleep(1500);
    }
}
