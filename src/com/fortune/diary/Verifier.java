package com.fortune.diary;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class Verifier extends DiaryHome {
    private static final Map<String, ArrayList<String>> credentials = new HashMap<>();
    private final String[] mInputArray = new String[4];
    private ObjectOutputStream out;
    private ObjectInputStream input;
    private DiaryHome mRecord;

    public static Map<String, ArrayList<String>> getCredentials() {
        return credentials;
    }

    public DiaryHome getRecord() {
        return mRecord;
    }

    public String[] getInputArray() {
        return mInputArray;
    }

    protected abstract boolean logInCredentials(String email, String password);

    protected abstract void signUpCredentials(String fullName, String email, String password);

    protected abstract boolean confirmCredentials(String email, String values);


    public void saveDetialSerr() {
        try {
            out = new ObjectOutputStream(Files.newOutputStream(Paths.get("signUpKeeper.ser")));
        } catch(IOException e) {
            System.err.println("Error creating file. Terminating...");
            System.exit(1);
        }
        int count = 0;
        while(count < credentials.size()) {
            try {
                DiaryHome mRecords = new DiaryHome(credentials.get(getUserEmail()).get(0), (credentials.containsKey(getUserEmail()) ? getUserEmail() : null),
                        credentials.get(getUserEmail()).get(1));
                out.writeObject(mRecords);
            } catch(IOException e) {
                System.err.println("Serial Faced Error writing to file. Terminating");
                break;
            }
            count++;
        }

        try {
            if(out != null) {
                out.close();
            }
        } catch(IOException e) {
            System.err.println("Error Occurred while Closing File.");
            System.exit(1);
        }
    }

    public void readSerDetails() {
        try {
            input = new ObjectInputStream(Files.newInputStream(Paths.get("signUpKeeper.ser")));
        } catch(IOException e) {
            System.err.println("Error Opening file. Terminating!");
        }

        try {
            while(true) {
                mRecord = (DiaryHome) input.readObject();
//                System.out.printf("%s %s %s", mRecord.getUserName(), mRecord.getUserEmail(), mRecord.getUserPassword());

            }
        } catch(EOFException eofException) {
            System.out.println("Checking Login Info");
        } catch(ClassNotFoundException e) {
            System.err.println("Class doesnt exist Oh");
        } catch(IOException exception) {
            System.err.println("Error Reading file");
            System.exit(1);
        }

        try {
            if(input != null) {
                input.close();
            }
        } catch(IOException ioException) {
            System.err.println("Error closing file. Terminating.");
            System.exit(1);
        }

    }
}
