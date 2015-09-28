package com.solidopinion.pageobjects.welcome;

import com.codeborne.selenide.SelenideElement;
import com.solidopinion.pageobjects.BasePage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class WelcomePage extends BasePage {

    public SelenideElement title(){
        return $("#page_container .welcome-title");
    }
}
