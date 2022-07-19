package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.not;

import android.os.SystemClock;

import androidx.test.espresso.matcher.ViewMatchers;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.elements.MainScreen;

public class MainSteps {

    MainScreen MainScreen = new MainScreen();

    @Step("Проверка отображения главного экрана")
    public void isMainScreen() {
        MainScreen.allNewsLink.check(matches(isDisplayed()));
        MainScreen.newsLabel.check(matches(withText("News")));
    }

    @Step("Разворачивание блока новостей")
    public void expandNews() {
        MainScreen.expandNews.check(matches(isDisplayed()));
        MainScreen.expandNews.perform(click());
    }

    @Step("Разворачивание блока заявок")
    public void expandClaims() {
        MainScreen.expandClaims.check(matches(isDisplayed()));
        MainScreen.expandClaims.perform(click());
    }

    @Step("Проверка скрытия ссылки на все новости")
    public void allNewsNotDisplayed() {
        MainScreen.allNewsLink.check(matches(not(isDisplayed())));
    }

    @Step("Проверка видимости ссылки все новости")
    public void allNewsDisplayed() {
        MainScreen.allNewsLink.check(matches(isDisplayed()));
    }

    @Step("Проверка скрытия ссылки на Все заявки")
    public void allClaimsNotDisplayed() {
        MainScreen.allClaims.check(matches(not(isDisplayed())));
    }

    @Step("Проверка видимости ссылки Все заявки")
    public void allClaimsDisplayed() {
        MainScreen.allClaims.check(matches(isDisplayed()));
    }

    @Step("Клик на \"Все новости\"")
    public void openAllNews() {
        MainScreen.allNewsLink.check(matches(isDisplayed()));
        MainScreen.allNewsLink.perform(click());
    }

    @Step("Клик на \"Все заявки\"")
    public void openAllClaims() {
        MainScreen.allClaims.check(matches(isDisplayed()));
        MainScreen.allClaims.perform(click());
    }

    @Step("Разворачивание новости")
    public void expandSingleNews() {
        MainScreen.expandSingleNews.perform(actionOnItemAtPosition(0, click()));
        MainScreen.newsDescription.check(matches(isDisplayed()));
    }

    @Step("Сворачивание новость")
    public void collapseSingleNews() {
        MainScreen.categoryIcon.perform(click());
        MainScreen.newsDescriptionAfterCollapse.check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
    }

    @Step("Открытие заявки")
    public void openSingleClaim() {
        MainScreen.firstClaimExecutorName.perform(click());
        SystemClock.sleep(2000);
    }

    @Step("Создать заявку")
    public void createClaim() {
        MainScreen.addNewClaimButton.perform(click());
        SystemClock.sleep(1000);
    }
}
