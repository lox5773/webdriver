package com.lox.webdriver.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BasePage {

    public static final String SITE_URL = "http://demo.ckan.org";

    @FindBy(xpath = "html/body/header[1]/div/nav/ul/li[1]/a")
    private WebElement loginLink;

    @FindBy(xpath = "html/body/header[1]/div/nav/ul/li[2]/a")
    private WebElement registerLink;

    protected BasePage verifyPage() {
        verifyHeader();
        verifyFooter();
        verifyBody();
        return this;
    }

    protected BasePage verifyHeader() {
        assertThat(loginLink.getText(), is("Log in"));
        assertThat(registerLink.getText(), is("Register"));
        return this;
    }

    protected BasePage verifyFooter() {
        return this;
    }

    protected BasePage verifyBody() {
        return this;
    }
}
