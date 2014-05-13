package com.lox.webdriver.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.lox.webdriver.Data.*;

public class GroupPage extends BasePage {

    public static final String URL = SITE_URL + "/group";

    @FindBy(css=".nav.nav-pills>li:nth-child(3) a")
    private WebElement groupdButton;

    @FindBy(css = ".btn.btn-primary")
    private WebElement addGroupButton;

    @FindBy(css = "#field-title")
    private WebElement titleFieldGroup;

    @FindBy(css = "#field-description")
    private WebElement descriptionFieldGroup;

    @FindBy(css = "#field-image-url")
    private WebElement urlFieldGroup;

    @FindBy(css = ".btn.btn-primary")
    private WebElement createGroupButton;

    public GroupPage(WebDriver driver) {
        super(driver);
    }

    public GroupPage verifyGroupPage() {
        return this;
    }

    public GroupPage createGroup() {
        addGroupButton.click();
        titleFieldGroup.sendKeys(TEST_GROUP1);

        descriptionFieldGroup.sendKeys(TEST_GROUP1_DESCRIPTION);
        createGroupButton.click();
        return this;

    }

}
