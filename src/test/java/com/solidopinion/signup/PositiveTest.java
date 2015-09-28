package com.solidopinion.signup;

import com.solidopinion.BaseTest;
import com.solidopinion.ddt.TestDataProvider;
import com.solidopinion.models.UserData;
import com.solidopinion.pageobjects.welcome.WelcomePage;
import com.solidopinion.settings.Config;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class PositiveTest extends BaseTest {

    private SignupPage signUpPage;
    private WelcomePage welcomePage;

    @Test(groups = {"positive", "registration"}, dataProvider = "validRegister", dataProviderClass = TestDataProvider.class)
    public void registerValidUser(UserData validNewUser) {
        signUpPage = open(Config.BASE_URL + "/signup", SignupPage.class);
        signUpPage.setLang("en");
        welcomePage = signUpPage.validRegistration(validNewUser);

        welcomePage.title().shouldHave(text("Welcome to SolidOpinion!"));
        Assert.assertEquals(welcomePage.getCurrentUrl(replaceHttps), Config.BASE_URL + "/welcome", "Actual URL WelcomePage was not as expected");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        $("#user_name").click();
        $("a.signout").click();
        getWebDriver().manage().deleteAllCookies();
    }
}
