package com.lox.webdriver.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    public static final String URL = SITE_URL + "/user/login";

    @FindBy(id = "field-login")
    private WebElement userNameField;

    @FindBy(id = "field-password")
    private WebElement passwordField;

    @FindBy(xpath = ".//*[@id='content']/div[3]/div/section/div/form/div[4]/button")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage verifyLoginPage() {
        return this;
    }

    public LoginPage verifyUnsuccessfulLogin() {
        return this;
    }

    public DashboardPage loginAs(String username, String password) {
        userNameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
        return PageFactory.initElements(driver, DashboardPage.class);
    }
}
