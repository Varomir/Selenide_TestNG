package com.solidopinion.ddt;

import com.solidopinion.models.UserData;
import com.solidopinion.models.UserDataWithEmail;
import com.solidopinion.models.UserDataWithUnequalPass;
import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name = "validRegister", parallel = false)
    public static Object[][] testData00() {
        return new Object[][]{
                new Object[]{UserData.getUniqueUserData()},
        };
    }

    @DataProvider(name = "validation", parallel = false)
    public static Object[][] testData01() {

        UserData shortPassword = UserData.getUniqueUserData();
        shortPassword.setPassword("AsDf5");
        shortPassword.setPassword2("AsDf5");

        UserDataWithEmail existingEmail = new UserDataWithEmail();
        existingEmail.setUsername("unique");

        UserDataWithUnequalPass wrongPasswordPair = new UserDataWithUnequalPass();
        UserDataWithUnequalPass emptyPassword2 = new UserDataWithUnequalPass();
        emptyPassword2.setPassword("");
        emptyPassword2.setPassword2("");

        UserDataWithEmail wrongEmail = new UserDataWithEmail();
        wrongEmail.setEmail("bad_email@gmail.c");

        UserDataWithEmail wrongUsername = new UserDataWithEmail();
        wrongUsername.setEmail(UserData.getUniqueUserData().getEmail());
        wrongUsername.setUsername("__#@~!ы");

        UserDataWithEmail emptyEmail = new UserDataWithEmail();
        emptyEmail.setEmail("");

        UserDataWithEmail emptyUsername = new UserDataWithEmail();
        emptyUsername.setUsername("");

        return new Object[][]{
                new Object[]{shortPassword, "en", "Password must have from 6 to 20 characters"},
                new Object[]{wrongPasswordPair, "en", "Oops! Your passwords don’t match, try again."},
                new Object[]{emptyPassword2, "en", "Sorry, password can't be blank."},
                new Object[]{existingEmail, "en", "Sorry, this email is already in use. If you forgot your password, please click here."},
                new Object[]{wrongEmail, "en", "Please enter a valid email address."},
                new Object[]{wrongUsername,"en", "Apologies, \"Name\" allows only alphanumeric characters, hyphen, dash, underscores and spaces."},
                new Object[]{emptyEmail, "en", "Sorry, email can't be blank."},
                new Object[]{emptyUsername, "en", "Sorry, nickname can't be blank."},

                new Object[]{wrongPasswordPair, "ru", "Пароли не совпадают, пожалуйста, попробуйте еще раз"},
                new Object[]{shortPassword, "ru", "Пароль может содержать от 6 до 20 символов"},
                new Object[]{emptyPassword2, "ru", "Пароль не может быть пустым."},
                new Object[]{existingEmail, "ru", "Это адрес электронной почты уже используется. Если Вы забыли пароль, нажмите на эту ссылку."},
                new Object[]{wrongEmail, "ru", "Пожалуйста, введите корректный адрес электронной почты."},
                new Object[]{wrongUsername,"ru", "Допустимые для поля ”Имя” символы – символы латинского алфавита, цифры, тире, дефис, подчеркивание и пробел."},
                new Object[]{emptyEmail, "ru", "Поле эдектронной почты не может быть пустым."},
                new Object[]{emptyUsername, "ru", "Извините, поле имя не может быть пустым"},
        };
    }
}
