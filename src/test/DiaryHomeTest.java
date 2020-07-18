package test;

import com.fortune.diary.DiaryHome;
import com.fortune.diary.NewUser;
import com.fortune.diary.UserLogIn;
import com.fortune.diary.Verifiable;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class DiaryHomeTest {
    private static Logger sLogger;
    DiaryHome mDiaryHome;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        mDiaryHome = new DiaryHome();
        sLogger = Logger.getLogger(DiaryHomeTest.class.getName());
    }


    @Test
    void constructorTest(){
        try {
            DiaryHome construct = new DiaryHome("forgmailcom", "password");
            assertEquals("forgmailcom", construct.getUserEmail());
            assertNotNull(construct);
        }catch(IllegalArgumentException e){
            System.err.println(e.getMessage());
        }

        DiaryHome construct2 = new DiaryHome("User Name", "Email@email.com", "password");

        assertNotNull(construct2);
        assertEquals("User Name", construct2.getUserName());
        assertEquals("Email@email.com", construct2.getUserEmail());
        assertNull(mDiaryHome.getUserEmail());
    }
    @Test
    void signUpTest(){
        DiaryHome diaryHome = new NewUser();
        String name = "John Doe", email = "mail@email.com", psw = "password";
        System.out.println(diaryHome.onSignUp(name, email, psw));
      assertEquals(name, diaryHome.getUserName());
      assertEquals(email, diaryHome.getUserEmail());
      assertEquals(psw, diaryHome.getUserPassword());

    }

    @Test
    void logInTest(){
        DiaryHome diaryHome = new UserLogIn();
        signUpTest();
        String email = "tom.hue@email.com", psw = "password";
        diaryHome.onLogIn(email, psw);
        assertEquals(email, diaryHome.getUserEmail());
        System.out.println(Verifiable.credentials.toString());
        assertTrue(Verifiable.credentials.values().contains(psw));





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
        assertEquals(email, mDiaryHome.getUserEmail());
        sLogger.info(mDiaryHome.getUserEmail());
    }

}