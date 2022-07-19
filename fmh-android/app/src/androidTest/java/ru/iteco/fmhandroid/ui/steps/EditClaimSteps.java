package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import static ru.iteco.fmhandroid.ui.helpers.MainHelper.nestedScrollTo;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.elements.EditClaimScreen;

public class EditClaimSteps {

    EditClaimScreen EditClaimScreen = new EditClaimScreen();

    @Step("Проверка отображения экрана редактирования заявки")
    public void isClaimsEditScreen() {
        EditClaimScreen.claimStatus.check(matches(isDisplayed()));
    }

    @Step("Возврат назад")
    public void backFromClaim() {
        EditClaimScreen.backButton.perform(nestedScrollTo());
        EditClaimScreen.backButton.perform(click());
    }
}
