package ru.iteco.fmhandroid.ui;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withChild;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import static ru.iteco.fmhandroid.ui.helpers.MainHelper.checkClaimStatus;
import static ru.iteco.fmhandroid.ui.helpers.MainHelper.getTestCurrentDate;
import static ru.iteco.fmhandroid.ui.helpers.MainHelper.getCurrentTime;
import static ru.iteco.fmhandroid.ui.helpers.MainHelper.isDisplayedWithSwipe;

import android.os.SystemClock;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.NoSuchElementException;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.steps.AboutAppSteps;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.ClaimsSteps;
import ru.iteco.fmhandroid.ui.steps.OverallSteps;
import ru.iteco.fmhandroid.ui.steps.ControlPanelSteps;
import ru.iteco.fmhandroid.ui.steps.CreateClaimSteps;
import ru.iteco.fmhandroid.ui.steps.CreateNewsSteps;
import ru.iteco.fmhandroid.ui.steps.EditClaimSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;
import ru.iteco.fmhandroid.ui.steps.NewsFilterSteps;
import ru.iteco.fmhandroid.ui.steps.NewsSteps;
import ru.iteco.fmhandroid.ui.steps.QuotesSteps;

@RunWith(AllureAndroidJUnit4.class)
public class CurrentPage {

    AuthorizationSteps AuthorizationSteps = new AuthorizationSteps();
    MainSteps MainSteps = new MainSteps();
    NewsSteps NewsSteps = new NewsSteps();
    ClaimsSteps ClaimsSteps = new ClaimsSteps();
    EditClaimSteps EditClaimSteps = new EditClaimSteps();
    CreateClaimSteps CreateClaimSteps = new CreateClaimSteps();
    OverallSteps OverallSteps = new OverallSteps();
    ControlPanelSteps ControlPanelSteps = new ControlPanelSteps();
    CreateNewsSteps CreateNewsSteps = new CreateNewsSteps();
    NewsFilterSteps NewsFilterSteps = new NewsFilterSteps();
    AboutAppSteps AboutAppSteps = new AboutAppSteps();
    QuotesSteps QuotesSteps = new QuotesSteps();

    public static String newsTitleString = "???????????????? ?????????? " + getTestCurrentDate() + "??" + getCurrentTime();
    public static String newsDescriptionString = "???????????????? ???????????????? " + getTestCurrentDate() + "??" + getCurrentTime();
    public static String newNewsTitle = "?????????????????? ??????-???? ???????????????????? " + getTestCurrentDate() + "??" + getCurrentTime();
    String newsPublicationDate = getTestCurrentDate();
    String newsTime = getCurrentTime();

    @Rule
    public ActivityTestRule<AppActivity> mActivityTestRule = new ActivityTestRule<>(AppActivity.class);

    @Before
    public void loginCheck() {
        SystemClock.sleep(6000);
        try {
            AuthorizationSteps.isAuthorizationScreen();
        } catch (NoMatchingViewException e) {
            return;
        }
        AuthorizationSteps.enterLogin("login2");
        AuthorizationSteps.enterPassword("password2");
        AuthorizationSteps.clickSignInButton();
        SystemClock.sleep(2000);
    }

    @Test
    @DisplayName("???????????????????????????? ?????????? ???????????????? ?? ????????????")
    public void expandAll() {
        MainSteps.expandNews();
        MainSteps.allNewsNotDisplayed();
        MainSteps.expandClaims();
        MainSteps.allClaimsNotDisplayed();

        MainSteps.expandNews();
        MainSteps.allNewsDisplayed();
        MainSteps.expandClaims();
        MainSteps.allClaimsDisplayed();
    }

    @Test
    @DisplayName("???????????????? ???????????? ????????????????")
    public void openAllNews() {
        MainSteps.openAllNews();
        NewsSteps.isNewsScreen();
    }

    @Test
    @DisplayName("???????????????? ???????????? ????????????")
    public void openAllClaims() {
        MainSteps.openAllClaims();
        ClaimsSteps.isClaimsScreen();
    }

    @Test
    @DisplayName("???????????????????????????? ?????????? ??????????????")
    public void expandSingleNews() {
        MainSteps.expandSingleNews();
        MainSteps.collapseSingleNews();
    }

    @Test
    @DisplayName("???????????????? ????????????")
    public void openSingleClaim() {
        MainSteps.expandNews();
        MainSteps.openSingleClaim();
        EditClaimSteps.isClaimsEditScreen();
        EditClaimSteps.backFromClaim();
        MainSteps.isMainScreen();
    }

    @Test
    @DisplayName("???????????????? ????????????")
    public void createClaim() {
        String claimTitleString = "???????????????? ?????????? " + getTestCurrentDate() + "??" + getCurrentTime();
        String newClaimTitleString = "???????????????? ???????????????? ???????????? " + getTestCurrentDate();
        String currentDate = getTestCurrentDate();
        String currentTime = getCurrentTime();
        MainSteps.createClaim();
        SystemClock.sleep(1000);

        CreateClaimSteps.isCreateClaimsScreen();
        CreateClaimSteps.checkClaimTitleLength();

        OverallSteps.clickSave();
        CreateClaimSteps.checkToastEmptyFields();
        OverallSteps.clickOK();

        CreateClaimSteps.enterClaimTitle(claimTitleString);
        CreateClaimSteps.selectExecutor();
        CreateClaimSteps.enterClaimDate(currentDate);
        CreateClaimSteps.enterClaimTime(currentTime);
        CreateClaimSteps.enterClaimDescription(newClaimTitleString);

        OverallSteps.clickCancel();
        OverallSteps.clickCancelText();
        CreateClaimSteps.isCreateClaimsScreen();

        OverallSteps.clickCancel();
        OverallSteps.clickOK();
        MainSteps.isMainScreen();


        MainSteps.createClaim();
        CreateClaimSteps.isCreateClaimsScreen();
        CreateClaimSteps.enterClaimTitle(claimTitleString);
        CreateClaimSteps.selectExecutor();
        CreateClaimSteps.enterClaimDate(currentDate);
        CreateClaimSteps.enterClaimTime(currentTime);
        CreateClaimSteps.enterClaimDescription(newClaimTitleString);
        OverallSteps.clickSave();
        SystemClock.sleep(1000);

        MainSteps.openAllClaims();

        if (isDisplayedWithSwipe(onView(withText(claimTitleString)), 2, true)) {
            onView(withText(claimTitleString)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        } else {
            throw new NoSuchElementException("Not found " + onView(withText(claimTitleString)).toString());
        }
    }

    @Test
    @DisplayName("???????????????????? ????????????")
    public void filteringClaims() {
        MainSteps.openAllClaims();
        ClaimsSteps.openFiltering();
        ClaimsSteps.clickCheckboxInProgress();
        ClaimsSteps.clickCancel();
        ClaimsSteps.openFiltering();
        ClaimsSteps.checkCheckboxInProgress(true);

        ClaimsSteps.clickCheckboxInProgress();
        ClaimsSteps.clickOK();
        checkClaimStatus("Open");
        ClaimsSteps.isClaimsScreen();

        ClaimsSteps.openFiltering();
        ClaimsSteps.clickCheckboxOpen();
        ClaimsSteps.checkCheckboxOpen(false);
        ClaimsSteps.clickCheckboxInProgress();
        ClaimsSteps.checkCheckboxInProgress(true);
        ClaimsSteps.clickOK();
        checkClaimStatus("In progress");
        ClaimsSteps.isClaimsScreen();

        ClaimsSteps.openFiltering();
        ClaimsSteps.clickCheckboxExecuted();
        ClaimsSteps.checkCheckboxExecuted(true);
        ClaimsSteps.clickCheckboxInProgress();
        ClaimsSteps.checkCheckboxInProgress(false);
        ClaimsSteps.clickOK();
        checkClaimStatus("Executed");
        ClaimsSteps.isClaimsScreen();

        ClaimsSteps.openFiltering();
        ClaimsSteps.clickCheckboxCancelled();
        ClaimsSteps.checkCheckboxCancelled(true);
        ClaimsSteps.clickCheckboxExecuted();
        ClaimsSteps.checkCheckboxExecuted(false);
        ClaimsSteps.clickOK();
        checkClaimStatus("Canceled");
        ClaimsSteps.isClaimsScreen();
    }

    @Test
    @DisplayName("???????????????? ???????????? ???????????? ???? ???????? ?? ?????????????? ?? ???????????? ???????????????? ????????????")
    public void claimScreen() {
        OverallSteps.goToScreen("Claims");
        ClaimsSteps.isClaimsScreen();

        ClaimsSteps.createClaim();
        CreateClaimSteps.isCreateClaimsScreen();
    }

    @Test
    @DisplayName("???????????????????? ???????????????? ???? ???????????? ????????????????")
    public void newsScreenSorting() {
        OverallSteps.goToScreen("News");
        NewsSteps.isNewsScreen();

        String firstNews = NewsSteps.getFirstNewsTitle();
        NewsSteps.clickSortButton();
        String lastNews = NewsSteps.getLastNewsTitle();
        NewsSteps.clickSortButton();
        String firstNewsAgain = NewsSteps.getFirstNewsAgainTitle();
        assertEquals(firstNews, firstNewsAgain);
        assertEquals(firstNews, lastNews);
    }

    @Test
    @DisplayName("???????????????????? ???????????????? ???? ???????????? ???????????? ????????????????????")
    public void controlPanelSorting() {
        OverallSteps.goToScreen("News");
        NewsSteps.isNewsScreen();

        NewsSteps.goToControlPanel();

        String firstNews = NewsSteps.getFirstNewsTitle();
        String firstPublicationDate = ControlPanelSteps.getFirstNewsPublicationDate();
        String firstCreationDate = ControlPanelSteps.getFirstNewsCreationDate();
        NewsSteps.clickSortButton();
        String lastPublicationDate = ControlPanelSteps.getLastNewsPublicationDate();
        NewsSteps.clickSortButton();
        String firstNewsAgain = NewsSteps.getFirstNewsAgainTitle();
        String firstPublicationDateAgain = ControlPanelSteps.getFirstNewsPublicationDateAgain();
        String firstCreationDateAgain = ControlPanelSteps.getFirstNewsCreationDateAgain();
        assertEquals(firstNews, firstNewsAgain);
        assertEquals(firstPublicationDate, firstPublicationDateAgain);
        assertEquals(firstCreationDate, firstCreationDateAgain);
        assertNotEquals(firstPublicationDate, lastPublicationDate);
    }

    @Test
    @DisplayName("???????????????? ??????????????")
    public void controlPanelCreateNews() {
        OverallSteps.goToScreen("News");
        NewsSteps.isNewsScreen();
        NewsSteps.goToControlPanel();

        ControlPanelSteps.createNews();
        CreateNewsSteps.isCreateNewsScreen();
        CreateNewsSteps.selectNewsCategory();
        CreateNewsSteps.enterNewsTitle(newsTitleString);
        OverallSteps.clickCancel();
        OverallSteps.clickCancelText();
        CreateNewsSteps.checkNewsTitle(newsTitleString);
        OverallSteps.clickCancel();
        OverallSteps.clickOK();

        ControlPanelSteps.isControlPanel();
        ControlPanelSteps.createNews();
        CreateNewsSteps.isCreateNewsScreen();
        CreateNewsSteps.selectNewsCategory();
        CreateNewsSteps.enterNewsTitle(newsTitleString);
        CreateNewsSteps.enterNewsPublicationDate(newsPublicationDate);
        CreateNewsSteps.enterNewsTime(newsTime);
        CreateNewsSteps.enterNewsDescription(newsDescriptionString);
        CreateNewsSteps.checkNewsSwitcher();

        OverallSteps.clickSave();
        ControlPanelSteps.isControlPanel();
        if (isDisplayedWithSwipe(onView(withText(newsTitleString)), 1, true)) {
            onView(withText(newsTitleString)).check(matches(isDisplayed()));
        }

        onView(allOf(withId(R.id.delete_news_item_image_view), withParent(withParent(allOf(withId(R.id.news_item_material_card_view), withChild(withChild(withText(newsTitleString)))))))).perform(click());
        OverallSteps.clickOK();
    }


    @Test
    @DisplayName("???????????????????? ????????????????")
    public void newsScreenFiltering() {
        OverallSteps.goToScreen("News");
        NewsSteps.isNewsScreen();

        NewsSteps.goToControlPanel();
        ControlPanelSteps.isControlPanel();

        ControlPanelSteps.createNews();
        CreateNewsSteps.isCreateNewsScreen();
        CreateNewsSteps.selectNewsCategory();
        CreateNewsSteps.enterNewsTitle(newsTitleString);
        CreateNewsSteps.enterNewsPublicationDate(newsPublicationDate);
        CreateNewsSteps.enterNewsTime(newsTime);
        CreateNewsSteps.enterNewsDescription(newsDescriptionString);
        CreateNewsSteps.checkNewsSwitcher();

        OverallSteps.clickSave();
        ControlPanelSteps.isControlPanel();

        OverallSteps.goToScreen("News");
        NewsSteps.isNewsScreen();

        NewsSteps.openFilter();
        NewsFilterSteps.enterPublishDateStart(newsPublicationDate);
        NewsFilterSteps.enterPublishDateEnd(newsPublicationDate);
        NewsFilterSteps.clickFilter();

        NewsSteps.checkFirstNewsDate(newsPublicationDate);

        NewsSteps.goToControlPanel();
        ControlPanelSteps.isControlPanel();

        NewsSteps.openFilter();
        NewsFilterSteps.enterPublishDateStart(newsPublicationDate);
        NewsFilterSteps.enterPublishDateEnd(newsPublicationDate);
        NewsFilterSteps.clickFilter();

        ControlPanelSteps.checkFirstPublicationDate(newsPublicationDate);

        ControlPanelSteps.clickEditNews();
        CreateNewsSteps.clickNewsSwitcher();
        OverallSteps.clickSave();

        NewsSteps.openFilter();
        NewsFilterSteps.enterPublishDateStart(newsPublicationDate);
        NewsFilterSteps.enterPublishDateEnd(newsPublicationDate);
        NewsFilterSteps.clickCheckboxActive();
        NewsFilterSteps.checkCheckboxActive(false);
        NewsFilterSteps.checkCheckboxNotActive(true);
        NewsFilterSteps.clickFilter();

        ControlPanelSteps.checkFirstPublicationDateNotActive(newsPublicationDate);
        ControlPanelSteps.checkNewsStatus();

        ControlPanelSteps.checkNewsStatusNotActive();
        CreateNewsSteps.clickNewsSwitcher();
        OverallSteps.clickSave();

        NewsSteps.openFilter();
        NewsFilterSteps.enterPublishDateStart(newsPublicationDate);
        NewsFilterSteps.enterPublishDateEnd(newsPublicationDate);
        NewsFilterSteps.checkCheckboxActive(true);
        NewsFilterSteps.clickCheckboxNotActive();
        NewsFilterSteps.checkCheckboxNotActive(false);
        NewsFilterSteps.clickFilter();

        ControlPanelSteps.checkFirstPublicationDateActive(newsPublicationDate);
        ControlPanelSteps.checkNewsStatusActive();

        ControlPanelSteps.clickDeleteNews();
        OverallSteps.clickOK();
    }

    @Test
    @DisplayName("???????????????????????????? ?? ???????????????? ??????????????")
    public void newsEditingDeleting() {
        OverallSteps.goToScreen("News");
        NewsSteps.isNewsScreen();

        NewsSteps.goToControlPanel();
        ControlPanelSteps.isControlPanel();

        ControlPanelSteps.createNews();
        CreateNewsSteps.isCreateNewsScreen();
        CreateNewsSteps.selectNewsCategory();
        CreateNewsSteps.enterNewsTitle(newsTitleString);
        CreateNewsSteps.enterNewsPublicationDate(newsPublicationDate);
        CreateNewsSteps.enterNewsTime(newsTime);
        CreateNewsSteps.enterNewsDescription(newsDescriptionString);
        CreateNewsSteps.checkNewsSwitcher();

        OverallSteps.clickSave();
        ControlPanelSteps.isControlPanel();

        if (isDisplayedWithSwipe(onView(withText(newsTitleString)), 1, true)) {
            onView(withText(newsTitleString)).check(matches(isDisplayed())).perform(click());
        }

        ControlPanelSteps.checkNewsDescription(true);
        ControlPanelSteps.clickNewsTitle();
        SystemClock.sleep(1500);
        ControlPanelSteps.checkNewsDescription(false);

        ControlPanelSteps.clickEditThisNews();
        CreateNewsSteps.isEditNewsScreen();
        CreateNewsSteps.checkNewsTitle(newsTitleString);
        CreateNewsSteps.enterNewsTitle(newNewsTitle);
        OverallSteps.clickSave();

        ControlPanelSteps.isControlPanel();
        if (isDisplayedWithSwipe(onView(withText(newNewsTitle)), 1, true)) {
            onView(withText(newNewsTitle)).check(matches(isDisplayed()));
        }

        ControlPanelSteps.clickDeleteThisNews();
        OverallSteps.clickOK();
        SystemClock.sleep(1500);
        if (isDisplayedWithSwipe(onView(withText(newNewsTitle)), 1, false)) {
            throw new NoSuchElementException("Not delete!");
        }
    }

    @Test
    @DisplayName("???????????????? ???????????????????? ?? ???????????????????? ?? ?????????????? ???? ?????????????? ??????????")
    public void aboutScreenAndBackToMain() {
        OverallSteps.goToScreen("About");
        AboutAppSteps.checkEverythingYouWant();
        AboutAppSteps.goBack();
        MainSteps.isMainScreen();
    }

    @Test
    @DisplayName("???????????????? ???????????? ?????????? ?? ???????????????? ??????????????????????")
    public void thematicQuotes() {
        OverallSteps.goToThematicQuotes();
        QuotesSteps.checkAll();
        QuotesSteps.expandQuote();
        QuotesSteps.collapseQuote();
    }
}
