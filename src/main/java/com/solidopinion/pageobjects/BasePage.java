package com.solidopinion.pageobjects;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public abstract class BasePage {

    public String getCurrentUrl(boolean replaceHttps) {
        String url = getWebDriver().getCurrentUrl();
        if (replaceHttps && url.charAt(4) == 's') {
            url = url.replaceFirst("https", "http");
        }
        return url;
    }

    public void waitForPageLoad() {
        //$("#loading").shouldBe(Condition.disappear);
        $("#loading-background").shouldBe(Condition.disappear);
    }
}
