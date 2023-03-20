package org.lev.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.open;

public class Hooks {

    @Before
    public void openPage(){
        open("https://www.onliner.by/");
    }

    @After
    public void closeResources(){
        closeWindow();
        closeWebDriver();
    }
}
