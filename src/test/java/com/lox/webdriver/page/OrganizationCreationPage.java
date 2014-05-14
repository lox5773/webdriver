package com.lox.webdriver.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.lox.webdriver.Data.TEST_ORG1;
import static com.lox.webdriver.Data.TEST_ORG1_DESCRIPTION;

public class OrganizationCreationPage extends BasePage {

    public static final String URL = SITE_URL + "/organization/new";

    @FindBy(xpath = ".//*[@id='field-name']")
    private WebElement nameField;

    @FindBy(id = "field-description")
    private WebElement descriptionField;

    @FindBy(id = "field-image-url")
    private WebElement urlField;

    @FindBy(xpath = ".//*[@class='form-actions']/button")
    private WebElement createOrganizationButton;

    @FindBy(xpath = ".//*[@class='content']/nav/ul/li[2]/a")
    private WebElement organizationsTab;

    @FindBy(xpath = ".//*[@class='page_primary_action']/a")
    private WebElement addOrganizationbutton;

    public OrganizationCreationPage(WebDriver driver) {
        super(driver);
    }

    public OrganizationCreationPage createOrganization() {
        //organizationsTab.click();
        //addOrganizationbutton.click();

        nameField.sendKeys(TEST_ORG1);
        nameField.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath(".//*[@id='field-url']")).sendKeys(TEST_ORG1);

        descriptionField.sendKeys(TEST_ORG1_DESCRIPTION);
        createOrganizationButton.click();
        return this;
    }

    public OrganizationCreationPage verifyOrganizationCreationPage() {
        return this;
    }


}
