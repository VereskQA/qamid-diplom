package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class AuthorizationScreen {

    public ViewInteraction label = onView(withText("Authorization"));
    public ViewInteraction login = onView(withHint("Login"));
    public ViewInteraction password = onView(withHint("Password"));
    public ViewInteraction signInButton = onView(withId(R.id.enter_button));
}
