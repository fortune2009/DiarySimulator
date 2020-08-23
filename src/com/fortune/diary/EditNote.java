package com.fortune.diary;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class EditNote implements Retrievable {
//    private static LocalDate mDate = null;
    private static final LocalTime mTime = LocalTime.now();
    private static final Long nanoSeconds = (long) mTime.getNano();
    private final StringBuilder addTitle = new StringBuilder();
    private final StringBuilder addNote = new StringBuilder();
    private Formatter mOutput;
    private Scanner mInput;


    public StringBuilder getAddTitle() {
        return addTitle;
    }

    public StringBuilder getAddNote() {
        return addNote;
    }

    public void lastActivity() {
        System.out.println("\n\nWelcome");
        System.out.println("=================");
        getSavedNote();
        System.out.println();
        modifyDelete(2);
    }

    public void modifyDelete(int choice) {
        System.out.println("\nEnter 1 to Modify or 2 to Delete: ");
        if(choice == 1) {
            newDocument(addTitle, addNote);
        } else {
            System.out.println("Deleting...");
        }
    }

    public void saveNote(String title, String note) {
        try {
            mOutput = new Formatter("noteKeeper.txt");
        } catch(FileNotFoundException e) {
            System.err.println("Error opening file! Terminating...");
            System.exit(1);
        } catch(SecurityException e) {
            System.err.println("Write permission denied! Terminating...");
            System.exit(1);
        }

        try {
            mOutput.format("%s%n%s%n%s %s%n", title, note, mTime.minusNanos(nanoSeconds), LocalDate.now());
        } catch(FormatterClosedException e) {
            System.err.println("Error writing to file. Terminating...");
        }

        if(mOutput != null) {
            mOutput.close();
        }
    }

    public void getSavedNote() {
        try {
            mInput = new Scanner(Paths.get("noteKeeper.txt"));
        } catch(IOException e) {
            System.err.println("Error opening file! Terminating...");
            System.exit(1);
        }
        System.out.printf("%s%n", "Note Title:");
        while(mInput.hasNext()) {
            try {
                System.out.printf("%s%nNote Body:%n%s%n%s", mInput.useDelimiter("\\n").next(),
                        mInput.useDelimiter("\\n").next(), mInput.useDelimiter("\\n").next());
//                System.out.println("=================");
            } catch(NoSuchElementException e) {
                System.err.println("Retrieving text file improperly formed. Terminating...");
            } catch(NullPointerException e) {
                System.err.println("Null values in Arrays");
            }

        }
        mInput.close();
    }

    public void newDocument(StringBuilder title, StringBuilder note) {
        System.out.println("Add Title -> ");
        StringTokenizer tokenizer;
        do {
            tokenizer = new StringTokenizer(title.toString(), "\n");
            addTitle.append(title);
            System.out.println(getAddTitle());
        } while(!tokenizer.hasMoreTokens());

        System.out.println("Add Note -> ");
        addNote.append(note);
        System.out.println(getAddNote());
        saveNote(title.toString(), note.toString());
    }
}
