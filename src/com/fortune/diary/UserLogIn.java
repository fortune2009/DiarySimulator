package com.fortune.diary;


import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.stream.Stream;

public class UserLogIn extends DiaryHome implements Verifiable{
    private NewUser mNewUser;
    private EditNote mEditNote;

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

    }

    @Override
    public String logInCredentials(String email, String password) {

        if(confirmCredentials(email, password)) {
            return String.format("%nPassed!");

        }
        return String.format("%s%n", "Incorrect Email!");
    }

    @Override
    public void signUpCredentials(String fullName, String email, String password) {

    }

    @Override
    public boolean confirmCredentials(String email, String passwordName) {

        if(credentials.containsKey(email)){
           if(credentials.containsValue(mMapValues)){




          }
        }
        return false;
    }


}
