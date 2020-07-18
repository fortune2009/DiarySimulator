package com.fortune.diary;

import java.util.LinkedHashMap;
import java.util.Map;

public interface Verifiable {
 static Map<String, String[]> credentials = new LinkedHashMap<>();
    String[] mValues = new String[2];

    void logInCredentials(String email, String password);

    void signUpCredentials(String fullName, String email, String password);

    boolean confirmCredentials(String email, String[] values);


}
