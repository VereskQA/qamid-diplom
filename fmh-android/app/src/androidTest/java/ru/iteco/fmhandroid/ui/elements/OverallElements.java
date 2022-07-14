package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class OverallElements {
    public ViewInteraction portaitImage = onView((withId(R.id.authorization_image_button)));
    public ViewInteraction logoutButton = onView((withText("Log out")));

}
