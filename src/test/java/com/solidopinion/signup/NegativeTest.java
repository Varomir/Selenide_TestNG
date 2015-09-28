package com.solidopinion.signup;

import com.solidopinion.BaseTest;
import com.solidopinion.ddt.TestDataProvider;
import com.solidopinion.models.UserData;
import com.solidopinion.settings.Config;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

public class NegativeTest extends BaseTest {

    private SignupPage signUpPage;
    private ErrorMsgBlock message;

    @BeforeClass
    public void openSignUpPageOnlyOnce(){
        signUpPage = open(Config.BASE_URL + "/signup", SignupPage.class);
    }

    @Test(groups = {"negative", "registration"},dataProvider = "validation", dataProviderClass = TestDataProvider.class)
    public void signUpFormValidation(UserData userData, String lang,  String expErrorMessage) {
        signUpPage.setLang(lang);
        message = signUpPage.invalidRegistration(userData);

        message.alertError().shouldHave(text(expErrorMessage));
        Assert.assertEquals(signUpPage.getCurrentUrl(replaceHttps), Config.BASE_URL + "/signup/", "Actual URL WelcomePage was not as expected");
    }
}
