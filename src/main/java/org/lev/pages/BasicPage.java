package org.lev.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class BasicPage {

    public void clickBtn(By by) {
        $(by).click();
    }

    public void activateTheElement(By by){
        $(by).hover();
    }

    public void browseTheElement(By by){
        $(by);
    }
}
