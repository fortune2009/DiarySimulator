package com.fortune.diary;

import java.util.Arrays;

public class UserLogIn extends DiaryHome implements Verifiable{
    private EditNote mEditNote;

    public void setEditNote(EditNote editNote) {
        if(confirmCredentials(getUserEmail(),Verifiable.mValues)){

        }
        mEditNote = editNote;
    }

    @Override
    public void logInCredentials(String email, String password) {
        System.out.print("Enter UserName or Email: ");
        setUserEmail(email);
        System.out.print("Enter User Password: ");
        Arrays.fill(Verifiable.mValues, password);
        Verifiable.credentials.put(getUserEmail(), mValues);
    }

    @Override
    public void signUpCredentials(String fullName, String email, String password) {

    }

    @Override
    public boolean confirmCredentials(String email, String[] passwordName) {
        return Verifiable.credentials.containsKey(email) && Verifiable.credentials.containsValue(passwordName);
    }


}
