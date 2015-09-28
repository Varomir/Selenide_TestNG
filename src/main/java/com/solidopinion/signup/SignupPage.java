package com.solidopinion.signup;

import com.codeborne.selenide.Condition;
import com.solidopinion.models.UserData;
import com.solidopinion.pageobjects.BasePage;
import com.solidopinion.pageobjects.welcome.WelcomePage;

import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class SignupPage extends BasePage {

    private UserData userData;

    public void setLang(String lang) {
        if (lang.equals("ru")) {
            if ($("a[data-lang='ru']").has(not(Condition.cssClass("active")))) {
                $("a[data-lang='ru']").click();
            }
        } else {
            if ($("a[data-lang='en']").has(not(Condition.cssClass("active")))) {
                $("a[data-lang='en']").click();
            }
        }
    }

    public WelcomePage validRegistration(UserData userData) {
        fillData(userData);
        return page(WelcomePage.class);
    }

    public ErrorMsgBlock invalidRegistration(UserData userData) {
        fillData(userData);
        return page(ErrorMsgBlock.class);
    }

    private void fillData(UserData userData) {
        this.userData = userData;
        setUsername();
        setEmail();
        setPassword();
        setReEnterPassword();
        clickSignUp();
    }

    private void setUsername() {
        //$("#name").setValue(userData.getUsername()).waitUntil(Condition.);//userData.getUsername()), 250);
        $("#name").setValue(userData.getUsername()).pressTab(); //userData.getUsername()), 250);
    }

    private void setEmail() {
        $("#email").setValue(userData.getEmail()).pressTab(); //.waitUntil(Condition.hasText(userData.getEmail()), 250);
    }

    private void setPassword() {
        $("#password").setValue(userData.getPassword()).pressTab(); //.waitUntil(Condition.hasText(userData.getPassword()), 250);
    }

    private void setReEnterPassword() {
        $("#password2").setValue(userData.getPassword2()).pressTab(); //.waitUntil(Condition.hasText(userData.getPassword2()), 250);
    }

    private void setReEnterPassword(String password2) {
        $("#password2").setValue(password2);
    }

    private void clickSignUp() {
        $("#go_signup").click();
    }
}
