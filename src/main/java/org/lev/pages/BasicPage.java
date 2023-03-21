package org.lev.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class BasicPage {

    public void activateTheElement(By by){
        $(by).hover();
    }
}
