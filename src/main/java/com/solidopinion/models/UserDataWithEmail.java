package com.solidopinion.models;

public class UserDataWithEmail extends UserData {

    public UserDataWithEmail() {
        super();
    }

    @Override
    public String toString() {
        return "UserData: {'username':'" + getUsername() + "','email':'" + getEmail() + "'}";
    }
}
