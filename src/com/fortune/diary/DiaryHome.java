package com.fortune.diary;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DiaryHome {
    private String userName;
    private String userEmail;
    private String userPassword;

    public DiaryHome() {

    }

    public DiaryHome(String userEmail, String userPassword) {
        this("", userEmail, userPassword);
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    public DiaryHome(String userName, String userEmail, String userPassword) {
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        Matcher matcher = pattern.matcher(userEmail);
        if(!matcher.matches()) {
            throw new IllegalArgumentException("The email address " + userEmail +
                    " is " + "[invalid]");
        }
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    public void onLogIn(String email, String password){
        userEmail = email;
        userPassword = password;
    }

    public String onSignUp(String fullName, String email, String password){
        userName = fullName;
        userEmail = email;
        userPassword = password;
        return null;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {

            Pattern pattern = Pattern.compile("^(.+)@(.+)$");
            Matcher matcher = pattern.matcher(userEmail);
            if(!matcher.matches()) {
                throw new IllegalArgumentException("The email address " + userEmail +
                        " is " +  "[invalid]");
            }
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
