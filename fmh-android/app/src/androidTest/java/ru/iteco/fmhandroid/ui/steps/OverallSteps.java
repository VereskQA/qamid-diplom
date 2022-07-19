package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;

import android.os.SystemClock;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.elements.OverallElements;

public class OverallSteps {

    OverallElements OverallElements = new OverallElements();

    @Step("Кликнуть выйти из приложения")
    public void logout() {
        OverallElements.manImage.perform(click());
        OverallElements.exitButton.perform(click());
    }

    @Step("Кликнуть сохранить")
    public void clickSave() {
        OverallElements.buttonSave.perform(click());
        SystemClock.sleep(1500);
    }

    @Step("Кликнуть ОК")
    public void clickOK() {
        OverallElements.buttonOkText.perform(click());
    }

    @Step("Кликнуть отмена")
    public void clickCancel() {
        OverallElements.buttonCancel.perform(click());
    }

    @Step("Кликнуть отмена для подтверждения")
    public void clickCancelText() {
        OverallElements.buttonCancelText.perform(click());
    }

    @Step("Перейти в тематические цитаты")
    public void goToThematicQuotes() {
        OverallElements.thematicQuotes.perform(click());
    }

    @Step("Перейти к нужному экрану через меню")
    public void goToScreen(String screen) {
        OverallElements.mainMenu.perform(click());
        switch (screen) {
            case ("Main"):
                OverallElements.menuMain.perform(click());
                break;
            case ("News"):
                OverallElements.menuNews.perform(click());
                break;
            case ("About"):
                OverallElements.menuAbout.perform(click());
                break;
            case ("Claims"):
                OverallElements.menuClaims.perform(click());
                break;
        }
    }
}
