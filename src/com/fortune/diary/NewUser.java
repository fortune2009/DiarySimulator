package com.fortune.diary;

import java.util.ArrayList;
import java.util.Scanner;

public class NewUser extends Verifier {
    private Scanner mScanner;

    public NewUser() {
        super();

    }


    @Override
    public String onSignUp(String fullName, String email, String password) {
        super.onSignUp(fullName, email, password);
        signUpCredentials(fullName, email, password);
        saveDetialSerr();
        return String.format("%n%s", "Completed!");
    }


    @Override
    public void saveDetialSerr() {
        super.saveDetialSerr();
    }


    @Override
    public void signUpCredentials(String fullName, String email, String password) {
//        System.out.println("Sign Up\nEnter UserName: ");
//        setUserName(fullName);
//        System.out.println("Enter Email: ");
//        setUserEmail(email);
//        System.out.println("Enter Password: ");
//        setUserPassword(password);
        ArrayList<String> mArrayList = new ArrayList<>();
        mArrayList.add(fullName);
        mArrayList.add(password);
        getCredentials().put(email, mArrayList);
//        System.out.println(getCredentials().toString());
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
