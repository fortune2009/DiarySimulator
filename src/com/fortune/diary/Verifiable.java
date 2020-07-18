package com.fortune.diary;

import java.util.*;

public interface Verifiable {
 static Map<String, TreeMap<String,String>> credentials = new HashMap<>();
    TreeMap<String, String> mMapValues = new TreeMap<>();

    String logInCredentials(String email, String password);

    void signUpCredentials(String fullName, String email, String password);

    boolean confirmCredentials(String email,  String values);


}
