package com.lox.webdriver.page;

import org.openqa.selenium.WebDriver;

import static com.lox.webdriver.Data.*;

public class DashboardPage extends BasePage {

    public static final String URL = SITE_URL + "/dashboard";

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public DashboardPage verifyDashboardPage() {
        verifyPage();
        return this;
    }

    public DashboardPage verifySuccesfulRegistration() {
        verifySuccessLogin(TEST_USER1_FULL_NAME);
        driver.getPageSource().contains("signed up");
        return this;
    }
}
