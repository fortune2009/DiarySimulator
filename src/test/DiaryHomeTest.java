package test;

import com.fortune.diary.*;
import jdk.jfr.Timestamp;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class DiaryHomeTest {
    private static Logger sLogger;
    DiaryHome mDiaryHome;
    private Scanner mInput;
    private String[] mInputArray;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        mDiaryHome = new DiaryHome();
        sLogger = Logger.getLogger(DiaryHomeTest.class.getName());
    }


    @Test
    void constructorTest(){
        try {
             DiaryHome construct = new DiaryHome("forgmailcom", "password");
        }catch(IllegalArgumentException e){
            System.err.println(e.getMessage());

        }

        DiaryHome construct2 = new DiaryHome("User Name", "Email@email.com", "password");

        assertNotNull(construct2);
        assertEquals("User Name", construct2.getUserName());
        assertEquals("Email@email.com", construct2.getUserEmail());
        assertNull(mDiaryHome.getUserEmail());
        sLogger.info("Three Arguments Constructor == Name: " + construct2.getUserName() + ", Email: " + construct2.getUserEmail() +
                ", Psw: " + construct2.getUserPassword());
    }
    @Test
    void signUpTest(){
        DiaryHome diaryHome = new NewUser();
        String name = "John Doe", email = "mail@email.com", psw = "password";
        System.out.println(diaryHome.onSignUp(name, email, psw));
      assertEquals(name, diaryHome.getUserName());
      assertEquals(email, diaryHome.getUserEmail());
      assertEquals(psw, diaryHome.getUserPassword());

      sLogger.info("Name: " + diaryHome.getUserName() + ", Email: " + diaryHome.getUserEmail() +
              ", Psw: " + diaryHome.getUserPassword());
    }

    @Test
    void incorrectLogInTest(){
        DiaryHome logInHome = new UserLogIn();
        DiaryHome signUpHome = new NewUser();
        signUpHome.onSignUp("kelly", "sam@mail.com", "samo");
        String email = "tom.hue@email.com", psw = "password1";
        logInHome.onLogIn(email, psw);
        assertFalse(Verifier.credentials.containsKey(email));
        assertFalse(Verifier.credentials.containsValue(psw));
        sLogger.info(Verifier.credentials.toString());

    }

    @Test
    void passedLogInTest(){
        DiaryHome logInHome = new UserLogIn();
        DiaryHome signUpHome = new NewUser();
        signUpHome.onSignUp("kelly", "sam@mail.com", "samo");
        String email = "sam@mail.com", psw = "samo";
        logInHome.onLogIn(email, psw);
        assertTrue(Verifier.credentials.containsKey(email));
        assertTrue(Verifier.credentials.containsValue(psw));
        sLogger.info(Verifier.credentials.toString());
    }

    @Test
    void emailValidationMatchTest(){
        String email = "em....il@mail.com";
        try {
            mDiaryHome.setUserEmail(email);
        } catch(IllegalArgumentException e){
            System.err.println(e.getMessage());
        }
        assertEquals(email, mDiaryHome.getUserEmail());
        sLogger.info(mDiaryHome.getUserEmail());
    }

    @Test
    void emailValidationUnmatchTest(){
        String email = "emmailcom";
        try {
            mDiaryHome.setUserEmail(email);
        } catch(IllegalArgumentException e){
            System.err.println(e.getMessage());
        }

        assertNull(mDiaryHome.getUserEmail());
        sLogger.info(mDiaryHome.getUserEmail());
    }

    @Test
    void savedSignUpDataTest(){
        DiaryHome signUpData = new NewUser();
        String name = "John Doe", email = "mail@email.com", psw = "password";
        signUpData.onSignUp("kelly", "sam@mail.com", "samo");
        assertNotNull(signUpData);
    }

    @Test
    void retriveSignUpDataTest() {
        DiaryHome getData = new UserLogIn();
        String name = "John Doe", email = "mail@email.com", psw = "password";
//        getData.onLogIn(email, psw);

        getData.onLogIn("sam@mail.com", "samo");
        assertNotNull(getData);
    }

    @Test
    @DisplayName("Editor file test")
    void editNoteTest(){
        EditNote editNote = new EditNote();
        StringBuilder title = new StringBuilder("My First title ");
        StringBuilder note = new StringBuilder("I have many things to type");
        editNote.newDocument(title, note);
//        System.out.println(editNote.getAddTitle() + "\n" + editNote.getAddNote());
//        editNote.lastActivity();
//        editNote.getSavedNote();

    }
    @Test
    @DisplayName("Last saved test")
    void getSavedNoteTest (){
        EditNote getSaved = new EditNote();
        getSaved.getSavedNote();
    }

    @Test
    @DisplayName("Testing Overall User Journey")
    void userJourney(){
        DiaryHome userJourney = new UserLogIn();
        userJourney.onLogIn("sam@mail.com", "samo");
    }
}