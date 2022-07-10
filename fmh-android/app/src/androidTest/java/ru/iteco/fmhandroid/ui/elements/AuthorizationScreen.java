package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class AuthorizationScreen {

    public ViewInteraction label = onView(withText("Authorization"));
    public ViewInteraction login = onView(withId(R.id.login_test_input_edit));
    public ViewInteraction password = onView(withId(R.id.pass_test_input_edit));
    public ViewInteraction signInButton = onView(withId(R.id.enter_button));
}
