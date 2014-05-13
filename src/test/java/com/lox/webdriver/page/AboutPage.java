package com.lox.webdriver.page;

import org.openqa.selenium.WebDriver;

public class AboutPage extends BasePage {

    public static final String URL = SITE_URL + "/about";

    public AboutPage(WebDriver driver) {
        super(driver);
    }

    public AboutPage verifyAboutPage() {
        return this;
    }
}
