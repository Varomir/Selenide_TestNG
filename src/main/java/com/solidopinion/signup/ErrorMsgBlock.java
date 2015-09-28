package com.solidopinion.signup;

import com.codeborne.selenide.SelenideElement;
import com.solidopinion.pageobjects.BasePage;

import static com.codeborne.selenide.Selenide.$;

public class ErrorMsgBlock extends BasePage {

    public SelenideElement alertError() {
        waitForPageLoad();
        return $("#message");
    }
}
