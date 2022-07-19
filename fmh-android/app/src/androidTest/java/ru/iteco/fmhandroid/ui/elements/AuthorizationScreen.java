package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class AuthorizationScreen {

    public ViewInteraction label = onView(withId(R.id.test_label_auth));
    public ViewInteraction loginInput = onView(withId(R.id.login_test_input_edit));
    public ViewInteraction passwordInput = onView(withId(R.id.pass_test_input_edit));
    public ViewInteraction signInButton = onView(withId(R.id.enter_button));
}
