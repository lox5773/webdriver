package com.lox.webdriver.page;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public static final String URL = SITE_URL + "/";

    public HomePage verifyHomePage() {
        return verifyHeader()
                .verifyBody()
                .verifyFooter();
    }

    private HomePage verifyFooter() {
        return this;
    }

    private HomePage verifyBody() {
        return this;
    }

    private HomePage verifyHeader() {
        return this;
    }
}
