package com.fortune.diary;

import java.util.List;
import java.util.Map;
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
    public String onSignUp(String fullName, String email, String password) {
        super.onSignUp(fullName, email, password);
        signUpCredentials(fullName, email, password);
        return String.format("%n%s", "Completed!");
    }

    @Override
    public void signUpCredentials(String fullName, String email, String password) {
        System.out.println("Sign Up\nEnter UserName: ");
        setUserName(fullName);
        System.out.println("Enter Email: ");
        setUserEmail(email);
        System.out.println("Enter Password: ");
        setUserPassword(password);
        mMapValues.put(password, getUserName());
        credentials.put(getUserEmail(), mMapValues);
        System.out.println(credentials.toString());
    }

    @Override
    public String logInCredentials(String email, String password) {
        return null;
    }



    @Override
    public boolean confirmCredentials(String email, String password) {
        return false;
    }
}
