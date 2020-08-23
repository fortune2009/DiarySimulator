package com.fortune.diary;


public class UserLogIn extends Verifier {
    private final EditNote mEditNote = new EditNote();

    public UserLogIn() {

    }

    @Override
    public void onLogIn(String email, String password) {
        super.onLogIn(email, password);
//        System.out.printf("%10s%n","Login");
//        System.out.println("Enter Email: ");
//        System.out.println("Enter Password: ");
//        logInCredentials(email, password);
        if(logInCredentials(email, password)) {
            System.out.printf("%n%s", "Passed!");
            mEditNote.lastActivity();
        } else {
            System.out.printf("%s%n", "Incorrect Email and Password!");
        }
    }

    @Override
    public boolean logInCredentials(String email, String password) {
        readSerDetails();
        return getRecord().getUserEmail().equals(email) && getRecord().getUserPassword().equals(password);
    }

    @Override
    public void signUpCredentials(String fullName, String email, String password) {

    }

//    @Override
//    public void readSerDetails() {
//        super.readSerDetails();
//    }

    @Override
    public boolean confirmCredentials(String email, String passwordName) {
        if(getCredentials().containsKey(email)) {
            return getCredentials().get(email).get(1).equals(passwordName);
        }
        return false;
    }


}
