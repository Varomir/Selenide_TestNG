package com.solidopinion.models;

import java.util.Random;

public class UserData {

    private static final String USERNAME = "autotest-";
    private static final String USER_EMAIL = "test-";
    private static final long SUFIX = System.currentTimeMillis() / 10000;

    private String username = USERNAME + "01";
    private String email = USER_EMAIL + "01" + "@solidopinion.com";
    //private String password = "aut0Player";
    private String password = "Player";
    private String password2 = password;

    public static UserData getDefaultUserData() {
        return new UserData();
    }

    public static UserData getUniqueUserData() {
        UserData uniqueUserData = new UserData();
        uniqueUserData.setUsername(USERNAME + SUFIX);
        uniqueUserData.setEmail(USER_EMAIL + SUFIX + "@solidopinion.com");
        return uniqueUserData;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void generateEmail(){
        setEmail(USER_EMAIL + new Random().nextInt(999999) + "@solidopinion.com");
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    @Override
    public String toString() {
        return "UserData: {'username':'" + username + "','password':'" + password + "'}";
    }
}
