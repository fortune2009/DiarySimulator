package com.fortune.diary;

import java.util.Date;

public interface Retrivable {
    Date date = new Date();

    default Date showDate(){
        return date;
    }

    default void saveNote(){

    }

    default void deleteNote(){

    }
}
