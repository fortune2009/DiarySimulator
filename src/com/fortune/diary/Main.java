package com.fortune.diary;

import java.util.Scanner;

public class Main {
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Verifier diaryHome = new NewUser();
        System.out.println("Enter 1 to SignUp or 2 to LogIn: ");
        int option = input.nextInt();

        if(option == 1) {
            // Sign Up here

            // Full Name
            System.out.println("Sign Up\nFull Name: ");
            String fullName = input.next();
            input.nextLine();

            emailValidation(diaryHome, fullName);

        } else if(option == 2) {
            // Log In here to verify if details exists
            logInValidation();
        }


    }

    private static void logInValidation() {
        DiaryHome logIn = new UserLogIn();
        System.out.println("Log In\nEmail: ");
        String userEmail = input.next();

        System.out.println("Password: ");
        String userPassword = input.next();
        logIn.onLogIn(userEmail, userPassword);
    }

    private static void emailValidation(DiaryHome diaryHome, String fullName) {
        System.out.println("Email: ");
        String emailAddress = null;
        try {
            // Email validation
            emailAddress = input.next();
            // Password
            System.out.println("Password: ");
            String newPassword = input.next();
            System.out.println(diaryHome.onSignUp(fullName, emailAddress, newPassword));
            logInValidation();

        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            emailValidation(diaryHome, fullName);
//                System.exit(1);
        }
    }
}
