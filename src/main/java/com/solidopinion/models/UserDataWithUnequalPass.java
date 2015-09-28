package com.solidopinion.models;

public class UserDataWithUnequalPass extends UserData {


    public UserDataWithUnequalPass() {
        setPassword2(getPassword().replaceFirst("a","X"));
        generateEmail();
        setEmail(getEmail().replaceFirst("a","Z"));
    }


    @Override
    public String toString() {
        return "UserData: {'username':'" + getUsername()
                + "','password1':'" + getPassword()
                + "','password2':'" + getPassword2() + "'}";
    }
}
