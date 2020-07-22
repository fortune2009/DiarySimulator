package com.fortune.diary;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UserLogIn extends Verifier {
    private EditNote mEditNote = new EditNote();

    public UserLogIn(String userEmail, String userPassword) {
        super(userEmail, userPassword);
    }

    public UserLogIn() {

    }

    public void setEditNote(EditNote editNote) {
        mEditNote = editNote;
    }

    @Override
    public void onLogIn(String email, String password) {
        super.onLogIn(email, password);
        System.out.printf("%-5s%n","Login");
        System.out.println("Enter Email: ");
        System.out.println("Enter Password: ");
        logInCredentials(email, password);
        if(logInCredentials(email,password)){
            System.out.printf("%n%s", "Passed!");
            mEditNote.lastActivity();
        }else {
            System.out.printf("%s%n", "Incorrect Email and Password!");
        }
    }
    @Override
    public boolean logInCredentials(String email, String password) {
        retriveSignUpData();
        return getInputArray()[1].equals(email) && getInputArray()[2].equals(password);

//        if(confirmCredentials(email, password)) {
//            return String.format("%nPassed!");
//        }
//        return String.format("%s%n", "Incorrect Email!");
    }

    @Override
    public void signUpCredentials(String fullName, String email, String password) {

    }

    @Override
    public void retriveSignUpData() {
        super.retriveSignUpData();
    }

    @Override
    public boolean confirmCredentials(String email, String passwordName) {
        if(credentials.containsKey(email)){
            if(credentials.containsValue(passwordName)){
                return true;
            }
        }
        return false;
    }


}
