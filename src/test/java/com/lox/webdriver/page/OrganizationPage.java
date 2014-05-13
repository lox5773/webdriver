package com.lox.webdriver.page;

import org.openqa.selenium.WebDriver;

public class OrganizationPage extends BasePage {

    public static final String URL = SITE_URL + "/organization";

    public OrganizationPage(WebDriver driver) {
        super(driver);
    }

    public OrganizationPage verifyOrganizationPage() {
        return this;
    }
}
