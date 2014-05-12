package com.lox.webdriver;

import org.junit.Test;

public class HomeTest extends BaseTest {

    @Test
    public void homePage_should_load_successfully(){
        gotoHomePage()
        .verifyHomePage();
    }

}
