package com.fortune.diary;

import java.util.Arrays;
import java.util.Scanner;

public class NewUser extends DiaryHome implements Verifiable{
    private Scanner mScanner;


    public NewUser() {
    }

    public NewUser(String userEmail, String userPassword) {
        super(userEmail, userPassword);
    }

    public NewUser(String userName, String userEmail, String userPassword) {
        super(userName, userEmail, userPassword);
    }

    @Override
    public void onSignUp(String fullName, String email, String password) {
        signUpCredentials(fullName, email, password);
    }

    @Override
    public void signUpCredentials(String fullName, String email, String password) {
        System.out.print("Sign Up\nEnter UserName: ");
        setUserName(fullName);
        System.out.println("Enter Email: ");
        setUserEmail(email);
        System.out.print("Enter Password: ");
        setUserPassword(password);
        Arrays.fill(mValues, fullName);
        Arrays.fill(mValues, password);
        Verifiable.credentials.put(email, mValues);
    }

    @Override
    public void logInCredentials(String email, String password) {
    }



    @Override
    public boolean confirmCredentials(String email, String[] password) {
        return false;
    }
}
