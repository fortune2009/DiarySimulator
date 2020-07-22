package com.fortune.diary;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public abstract class Verifier extends DiaryHome{
    public static Map<String, String> credentials = new HashMap<>();
    private Formatter mOutput;
    private Scanner mInput;
    private final String[] mInputArray = new String[3];

    public String[] getInputArray() {
        return mInputArray;
    }

    public Verifier(String userEmail, String userPassword) {
    }

    public Verifier() {

    }

    protected abstract boolean logInCredentials(String email, String password);

    protected abstract void signUpCredentials(String fullName, String email, String password);

    protected abstract boolean confirmCredentials(String email, String values);

    public void saveSignUpData() {
            try{
                mOutput = new Formatter("signUp_data.txt");
            } catch(FileNotFoundException e) {
                System.err.println("Error opening file! Terminating...");
                System.exit(1);
            }
            catch(SecurityException e){
                System.err.println("Write permission denied! Terminating...");
                System.exit(1);
            }
        int count = 0;
        while(count< credentials.size()){
            try {
               mOutput.format("%s %s %s%n", getUserName(), (credentials.containsKey(getUserEmail()) ? getUserEmail() : null),
                           credentials.get(getUserEmail()));
            } catch(FormatterClosedException e) {
                System.err.println("Error writing to file. Terminating...");
            }
            count++;
        }

            if(mOutput != null) {
                mOutput.close();
            }
    }

    public void retriveSignUpData() {
        try{
            mInput = new Scanner(Paths.get("signUp_data.txt"));
        } catch(IOException e) {
            System.err.println("Error opening file! Terminating...");
            System.exit(1);
        }
//        System.out.printf("%-12s%-12s%10s%n", "Full Name", "Email", "Password");
        while(mInput.hasNext()){
            try {
//                System.out.printf("%-12s%-12s%10s%n", mInput.next(), mInput.next(),mInput.next());
                mInputArray[0] = mInput.next();
                mInputArray[1] = mInput.next();
                mInputArray[2] = mInput.next();
//                System.out.println(Arrays.toString(mInputArray));
            } catch(NoSuchElementException e) {
                System.err.println("File improperly formed. Terminating...");
            }
            catch(NullPointerException e){
                System.err.println("Null values in Arrays");
            }
        }
        mInput.close();
    }
}
