package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isChecked;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isNotChecked;

import android.os.SystemClock;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.elements.ClaimScreen;
import ru.iteco.fmhandroid.ui.elements.MainScreen;

public class ClaimsSteps {

    MainScreen MainScreen = new MainScreen();
    ClaimScreen ClaimScreen = new ClaimScreen();

    public void isClaimsScreen() {
        Allure.step("Проверка отображения экрана заявок");
        MainScreen.addNewClaimButton.check(matches(isDisplayed()));
        MainScreen.allNewsLink.check(doesNotExist());
    }

    public void openFiltering() {
        Allure.step("Открытие фильтра");
        ClaimScreen.claimFilterButton.perform(click());
        ClaimScreen.claimFilterTitle.check(matches(isDisplayed()));
    }

    public void clickCheckboxInProgress() {
        Allure.step("Установка чекбокса \"В процессе\"");
        ClaimScreen.inProgressFilter.perform(click());
    }

    public void clickCheckboxOpen() {
        Allure.step("Установка чекбокса \"Открыт\"");
        ClaimScreen.open.perform(click());
    }

    public void clickCheckboxExecuted() {
        Allure.step("Установка чекбокса \"Выполнен\"");
        ClaimScreen.executedFilter.perform(click());
    }

    public void clickCheckboxCancelled() {
        Allure.step("Установка чекбокса \"Отменен\"");
        ClaimScreen.cancelledFilter.perform(click());
    }

    public void clickCancel() {
        Allure.step("Клик \"Отмена\"");
        ClaimScreen.cancelButton.perform(click());
    }

    public void clickOK() {
        Allure.step("Клик \"ОК\"");
        ClaimScreen.okButton.perform(click());
    }

    public void checkCheckboxInProgress(boolean checked) {
        Allure.step("Проверка чекбокса \"В процессе\"");
        if (checked) {
            ClaimScreen.inProgressFilter.check(matches(isChecked()));
        } else {
            ClaimScreen.inProgressFilter.check(matches(isNotChecked()));
        }
    }

    public void checkCheckboxOpen(boolean checked) {
        Allure.step("Проверка чекбокса \"Открыт\"");
        if (checked) {
            ClaimScreen.open.check(matches(isChecked()));
        } else {
            ClaimScreen.open.check(matches(isNotChecked()));
        }
    }

    public void checkCheckboxExecuted(boolean checked) {
        Allure.step("Проверка чекбокса \"Выполнен\"");
        if (checked) {
            ClaimScreen.executedFilter.check(matches(isChecked()));
        } else {
            ClaimScreen.executedFilter.check(matches(isNotChecked()));
        }
    }

    public void checkCheckboxCancelled(boolean checked) {
        Allure.step("Проверка чекбокса \"Отменен\"");
        if (checked) {
            ClaimScreen.cancelledFilter.check(matches(isChecked()));
        } else {
            ClaimScreen.cancelledFilter.check(matches(isNotChecked()));
        }
    }

    public void createClaim() {
        Allure.step("Клик для создания заявки");
        ClaimScreen.addNewClaimButton.perform(click());
        SystemClock.sleep(1500);
    }
}
