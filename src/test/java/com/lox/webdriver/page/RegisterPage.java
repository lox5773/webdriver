package com.lox.webdriver.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.lox.webdriver.Data.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RegisterPage extends BasePage {

    public static final String URL = SITE_URL + "/user/register";

    @FindBy(xpath = "html/body/header[1]/div/nav/ul/li[2]/a")
    WebElement registerButton;

    @FindBy(xpath = ".//*[@id='field-username']")
    WebElement regUsernameField;

    @FindBy(xpath = ".//*[@id='field-fullname']")
    WebElement regFullNameField;

    @FindBy(xpath = ".//*[@id='field-email']")
    WebElement regEmailField;

    @FindBy(xpath = ".//*[@id='field-password']")
    WebElement regPasswordField;

    @FindBy(xpath = ".//*[@id='field-confirm-password']")
    WebElement regConfirmPasswordField;

    @FindBy(xpath = ".//*[@class='btn btn-primary']")
    WebElement regCreateAccountBtn;

    @FindBy(xpath = ".//*[@class='error-explanation alert alert-error ']")
    WebElement errorPanel;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public DashboardPage doRegistration() {
        registerButton.click();
        regUsernameField.sendKeys(TEST_USER1_NAME);
        regFullNameField.sendKeys(TEST_USER1_FULL_NAME);
        regEmailField.sendKeys(TEST_USER1_EMAIL);
        regPasswordField.sendKeys(TEST_USER1_PASSWORD);
        regConfirmPasswordField.sendKeys(TEST_USER1_PASSWORD);
        regCreateAccountBtn.click();
        return PageFactory.initElements(driver, DashboardPage.class);
    }

    public DashboardPage doRegistrationWith(String userName, String fullName, String email, String password) {
        registerButton.click();
        regUsernameField.sendKeys(userName);
        regFullNameField.sendKeys(fullName);
        regEmailField.sendKeys(email);
        regPasswordField.sendKeys(password);
        regConfirmPasswordField.sendKeys(password);
        regCreateAccountBtn.click();
        return PageFactory.initElements(driver, DashboardPage.class);
    }

    public RegisterPage doRegistrationWithoutRequiredFields() {
        registerButton.click();
        regUsernameField.sendKeys(TEST_USER1_NAME);
        regCreateAccountBtn.click();
        return PageFactory.initElements(driver, RegisterPage.class);
    }

    public RegisterPage verifyRegisterPage() {
        return this;
    }

    public RegisterPage verifyUnsuccesfulRegistration() {
        System.out.println(errorPanel.getText());
        assertThat(errorPanel.isDisplayed(), is(true));
        assertThat(errorPanel.getText().contains("The form contains invalid entries:"), is(true));
        return this;
    }
}
