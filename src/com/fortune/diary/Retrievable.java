package com.fortune.diary;

import java.util.Date;

public interface Retrievable {
    Date date = new Date();

    default Date showDate() {
        return date;
    }

    void saveNote(String title, String note);

    default void deleteNote() {

    }
}
