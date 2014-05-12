package com.lox.webdriver.page;

public class HomePage extends BasePage {

    public static final String URL = SITE_URL + "/";

    public HomePage verifyHomePage() {
        verifyPage();
        return this;
    }

}
