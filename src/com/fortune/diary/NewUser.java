package com.fortune.diary;

import java.util.Scanner;

public class NewUser extends Verifier {
    private Scanner mScanner;

    public NewUser(){
        super();

    }
    public NewUser(String userEmail, String userPassword) {
        super(userEmail, userPassword);
    }

    @Override
    public String onSignUp(String fullName, String email, String password) {
        super.onSignUp(fullName, email, password);
        signUpCredentials(fullName, email, password);
        saveSignUpData();
        return String.format("%n%s", "Completed!");
    }

    @Override
    public void saveSignUpData() {
        super.saveSignUpData();
    }

    @Override
    public void signUpCredentials(String fullName, String email, String password) {
        System.out.println("Sign Up\nEnter UserName: ");
        setUserName(fullName);
        System.out.println("Enter Email: ");
        setUserEmail(email);
        System.out.println("Enter Password: ");
        setUserPassword(password);
        credentials.put(getUserEmail(), getUserPassword());
        System.out.println(credentials.toString());
    }

    @Override
    protected boolean logInCredentials(String email, String password) {
        return false;
    }

    @Override
    public boolean confirmCredentials(String email, String password) {
        return false;
    }
}
