package com.lox.webdriver;

import org.junit.Test;

public class AboutTest extends BaseTest {

    @Test
    public void aboutPage_should_load_successfully(){
        gotoAboutPage()
        .verifyAboutPage();
    }

}
