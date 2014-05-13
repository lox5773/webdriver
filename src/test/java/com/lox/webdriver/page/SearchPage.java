package com.lox.webdriver.page;

import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage {

    public static final String URL = SITE_URL + "/";

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public SearchPage verifySearchPage() {
        return this;
    }
}
