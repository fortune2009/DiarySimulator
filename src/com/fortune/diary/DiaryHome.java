package com.fortune.diary;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DiaryHome {
    private Verifiable mVerifiable;
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
        System.out.println("The email address " + userEmail +
                " is " + (matcher.matches() ? "[valid]" : "[invalid]"));
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }
    public void onLogIn(int choice){
        System.out.println("Enter 1 to Login " +
                "\nEnter 2 to SignUp");
        if(choice == 1){
        mVerifiable.logInCredentials(userEmail, userPassword);
        }
        else if(choice == 2){
            mVerifiable.signUpCredentials(userName, userEmail, userPassword);
        }
    }

    public void onSignUp(String fullName, String email, String password){

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
        System.out.println("The email address " + userEmail +
                " is " + (matcher.matches() ? "[valid]" : "[invalid]"));
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
