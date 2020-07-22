package com.fortune.diary;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.Clock;
import java.time.LocalDateTime;
import java.util.*;

public class EditNote implements Retrievable {
    private final LocalDateTime mDateTime = LocalDateTime.now();
    private StringBuilder addTitle = new StringBuilder();
    private StringBuilder addNote = new StringBuilder();
    private Formatter mOutput;
    private Scanner mInput;

    public StringBuilder getAddTitle() {
        return addTitle;
    }

    public void setAddTitle(StringBuilder addTitle) {
        this.addTitle = addTitle;
    }

    public StringBuilder getAddNote() {
        return addNote;
    }

    public void setAddNote(StringBuilder addNote) {
        this.addNote = addNote;
    }

    public Formatter getOutput() {
        return mOutput;
    }

    public void setOutput(Formatter output) {
        mOutput = output;
    }

    public void lastActivity(){
        System.out.println("\n\nWelcome");
        getSavedNote();
        modifyDelete(2);
    }

    public void modifyDelete(int choice){
        System.out.println("\nEnter 1 to Modify or 2 to Delete: ");
        if(choice == 1) {
            newDocument(addTitle, addNote);
        } else {
            System.out.println("Deleting...");
        }
    }

    public void saveNote(String title, String note) {
        try{
            mOutput = new Formatter("noteKeeper.txt");
        } catch(FileNotFoundException e) {
            System.err.println("Error opening file! Terminating...");
            System.exit(1);
        }
        catch(SecurityException e){
            System.err.println("Write permission denied! Terminating...");
            System.exit(1);
        }

        try {
            mOutput.format("%-20s%s %-5s%n", title, note, mDateTime.toLocalDate().toString());
        } catch(FormatterClosedException e) {
            System.err.println("Error writing to file. Terminating...");
        }

        if(mOutput != null) {
            mOutput.close();
        }
    }

    public void getSavedNote() {
        try{
            mInput = new Scanner(Paths.get("noteKeeper.txt"));
        } catch(IOException e) {
            System.err.println("Error opening file! Terminating...");
            System.exit(1);
        }
        System.out.printf("%s%n", "Note Title:");
        while(mInput.hasNext()){
            try {
                System.out.printf("%s%s%nNote Body:%n%s%n", mInput.next(), mInput.nextLine(), mInput.nextLine());
            } catch(NoSuchElementException e) {
                System.err.println("File improperly formed. Terminating...");
            }
            catch(NullPointerException e){
                System.err.println("Null values in Arrays");
            }
        }
        System.out.println(mInput.locale());
        mInput.close();
    }

    public void newDocument(StringBuilder title, StringBuilder note) {
        System.out.println("Add Title -> ");
        StringTokenizer tokenizer;
      do {
          tokenizer = new StringTokenizer(title.toString(), "\n");
          addTitle.append(title);
          System.out.println(getAddTitle());
      }while(!tokenizer.hasMoreTokens());

        System.out.println("Add Note -> ");
        addNote.append(note);
        System.out.println(getAddNote());
        saveNote(title.toString(), note.toString());
    }
}
