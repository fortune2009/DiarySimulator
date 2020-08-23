package test.com.fortune.diary;


import com.fortune.diary.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

class DiaryHomeTest {
    private static Logger sLogger;
    DiaryHome mDiaryHome;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        mDiaryHome = new DiaryHome();
        sLogger = Logger.getLogger(DiaryHomeTest.class.getName());
    }


    @Test
    @DisplayName("Testing Constructors")
    void constructorTest() {
        try {
            DiaryHome construct = new DiaryHome("forgmailcom", "password");
            Assertions.assertNotNull(construct);
        } catch(IllegalArgumentException e) {
            System.err.println(e.getMessage());

        }

        DiaryHome construct2 = new DiaryHome("User Name", "Email@email.com", "password");

        Assertions.assertNotNull(construct2);
        Assertions.assertEquals("User Name", construct2.getUserName());
        Assertions.assertEquals("Email@email.com", construct2.getUserEmail());
        Assertions.assertNull(mDiaryHome.getUserEmail());
        sLogger.info("Three Arguments Constructor == Name: " + construct2.getUserName() + ", Email: " + construct2.getUserEmail() +
                ", Psw: " + construct2.getUserPassword());
    }

    @Test
    void signUpTest() {
        DiaryHome diaryHome = new NewUser();
        String name = "John Doe", email = "mail@email.com", psw = "password";
        System.out.println(diaryHome.onSignUp(name, email, psw));
        Assertions.assertEquals(name, diaryHome.getUserName());
        Assertions.assertEquals(email, diaryHome.getUserEmail());
        Assertions.assertEquals(psw, diaryHome.getUserPassword());

        sLogger.info("Name: " + diaryHome.getUserName() + ", Email: " + diaryHome.getUserEmail() +
                ", Psw: " + diaryHome.getUserPassword());
    }

    @Test
    void incorrectLogInTest() {
        DiaryHome logInHome = new UserLogIn();
        DiaryHome signUpHome = new NewUser();
        signUpHome.onSignUp("kelly", "sam@mail.com", "samo");
        String email = "tom.hue@email.com", psw = "password1";
        logInHome.onLogIn(email, psw);
        Assertions.assertFalse(Verifier.getCredentials().containsKey(email));
        Assertions.assertFalse(Verifier.getCredentials().containsValue(psw));
        sLogger.info(Verifier.getCredentials().toString());

    }

    @Test
    void passedLogInTest() {
        DiaryHome logInHome = new UserLogIn();
        DiaryHome signUpHome = new NewUser();
        signUpHome.onSignUp("kelly Jake", "sam@mail.com", "samo");
        String email = "sam@mail.com", psw = "samo";
        logInHome.onLogIn(email, psw);
        Assertions.assertTrue(Verifier.getCredentials().containsKey(email));
        Assertions.assertEquals(Verifier.getCredentials().get(email).get(1), psw);
        sLogger.info(Verifier.getCredentials().toString());
    }

    @Test
    void emailValidationMatchTest() {
        String email = "em....il@mail.com";
        try {
            mDiaryHome.setUserEmail(email);
        } catch(IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        Assertions.assertEquals(email, mDiaryHome.getUserEmail());
        sLogger.info(mDiaryHome.getUserEmail());
    }

    @Test
    void emailValidationUnmatchTest() {
        String email = "emmailcom";
        try {
            mDiaryHome.setUserEmail(email);
        } catch(IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        Assertions.assertNull(mDiaryHome.getUserEmail());
        sLogger.info(mDiaryHome.getUserEmail());
    }

    @Test
    void savedSignUpDataTest() {
        DiaryHome signUpData = new NewUser();
        String name = "John Doe", email = "mail@email.com", psw = "password";
        signUpData.onSignUp(name, email, psw);
        Assertions.assertNotNull(signUpData);
    }

    @Test
    void retrieveSignUpDataTest() {
        DiaryHome getData = new UserLogIn();
        String name = "John Doe", email = "mail@email.com", psw = "password";
        getData.onLogIn(email, psw);

//        getData.onLogIn("sam@mail.com", "samo");
        Assertions.assertNotNull(getData);
    }

    @Test
    @DisplayName("Editor file test")
    void editNoteTest() {
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
    void getSavedNoteTest() {
        EditNote getSaved = new EditNote();
        getSaved.getSavedNote();
    }

    @Test
    @DisplayName("Testing Overall User Journey")
    void userJourney() {
        DiaryHome userJourney = new UserLogIn();
        userJourney.onLogIn("sam@mail.com", "samo");
    }
}