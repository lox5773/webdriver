package com.lox.webdriver;

import org.junit.Test;

public class RegisterTest extends BaseTest {

    @Test
    public void registerPage_should_load_successfully(){
        gotoRegisterPage()
        .verifyRegisterPage();
    }

    @Test
    public void successful_registration(){
        gotoRegisterPage()
                .doRegistration()
                .verifySuccesfulRegistration();
    }

    @Test
    public void unsuccessful_registration_given_mandatory_fields_are_not_provided(){
        gotoRegisterPage()
                .doRegistrationWithoutRequiredFields()
                .verifyUnsuccesfulRegistration();
    }

    public void after(){
        //write code here to delete user TEST_USER_NAME
        super.after();
    }

}
