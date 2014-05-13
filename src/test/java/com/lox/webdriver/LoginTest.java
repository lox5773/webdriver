package com.lox.webdriver;

import org.junit.Test;
import static com.lox.webdriver.Data.*;

public class LoginTest extends BaseTest {

    public void before(){
        super.before();
        gotoRegisterPage()
                .doRegistrationWith(TEST_USER_NAME, TEST_USER_FULL_NAME, TEST_USER_EMAIL, TEST_USER_PASSWORD)
                .doLogout();
    }

    public void after(){
        //write code here to delete user TEST_USER_NAME
        super.after();
    }

    @Test
    public void loginPage_should_load_successfully(){
        gotoLoginPage()
                .verifyLoginPage();
    }

    @Test
    public void should_login_successfully(){
        gotoLoginPage()
                .loginAs(TEST_USER_NAME, TEST_USER_PASSWORD)
                .verifySuccessLogin(TEST_USER_FULL_NAME);
    }

    @Test
    public void should_fail_login_given_incorrect_username(){
        gotoLoginPage()
                .loginAs("FakeUserName", TEST_USER_PASSWORD)
                .verifyUnsuccessfulLogin();
    }

    @Test
    public void should_fail_login_given_incorrect_password(){
        gotoLoginPage()
                .loginAs(TEST_USER_NAME, "FakePassword")
                .verifyUnsuccessfulLogin();
    }

    @Test
    public void should_fail_login_given_incorrect_username_and_password(){
        gotoLoginPage()
                .loginAs("FakeUserName", "FakePassword")
                .verifyUnsuccessfulLogin();
    }
}
