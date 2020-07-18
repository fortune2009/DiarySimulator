package test;

import com.fortune.diary.DiaryHome;
import com.fortune.diary.NewUser;
import org.junit.jupiter.api.AfterEach;
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
        DiaryHome construct = new DiaryHome("forgmailcom", "password");
        assertNotNull(construct);
        DiaryHome construct2 = new DiaryHome("User Name", "Email@email.com", "password");
        assertNotNull(construct2);
        assertEquals("User Name", construct2.getUserName());
        assertEquals("Email@email.com", construct2.getUserEmail());
        assertEquals("forgmailcom", construct.getUserEmail());
        assertNull(mDiaryHome.getUserEmail());
    }
    @Test
    void signUpTest(){
        String name = "John Doe", email = "mail@email.com", psw = "password";
        mDiaryHome.setUserName(name);
      mDiaryHome.onSignUp(name, email, psw);
      assertEquals(name, mDiaryHome.getUserName());
//      assertEquals(email, mDiaryHome.getUserEmail());




    }

    @Test
    void signUpCancelTest(){


    }

    @Test
    void emailValidationTest(){
        String email = "em....il@mail.com";
        mDiaryHome.setUserEmail(email);
        assertEquals(email, mDiaryHome.getUserEmail());
        sLogger.info(mDiaryHome.getUserEmail());
    }


}