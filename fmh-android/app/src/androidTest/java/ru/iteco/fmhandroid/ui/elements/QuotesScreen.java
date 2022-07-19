package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static ru.iteco.fmhandroid.ui.helpers.MainHelper.withIndex;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class QuotesScreen {

    public ViewInteraction titleText = onView(withId(R.id.our_mission_title_text_view));
    public ViewInteraction image = onView(withIndex(withId(R.id.our_mission_item_image_view), 0));
    public ViewInteraction quoteTitle = onView(withIndex(withId(R.id.our_mission_item_title_text_view), 0));
    public ViewInteraction quoteTitleClickable = onView(withIndex(withId(R.id.our_mission_item_title_text_view), 0));
    public ViewInteraction quoteTitleClickable2 = onView(withIndex(withId(R.id.our_mission_item_title_text_view), 0));
    public ViewInteraction quoteDescription = onView(withIndex(withId(R.id.our_mission_item_description_text_view), 0));
    public ViewInteraction quoteDescriptionAfterClick = onView(withIndex(withId(R.id.our_mission_item_description_text_view), 0));
}
