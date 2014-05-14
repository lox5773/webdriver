package com.lox.webdriver.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrganizationListPage extends BasePage {

    public static final String URL = SITE_URL + "/organization";

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

    public OrganizationListPage(WebDriver driver) {
        super(driver);
    }

    public OrganizationListPage deleteOrganization(String orgName) {
        //goto http://sl-dev-intersect-01.dev.test/organization/testorg1
        //that return OrganizationDetailPage
        //click on manage button
        //click on Delete button
        //click on confirm from popup
        return this;
    }

    public OrganizationListPage verifyOrganizationListPage() {
        return this;
    }

}
