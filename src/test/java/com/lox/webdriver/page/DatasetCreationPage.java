package com.lox.webdriver.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.lox.webdriver.Data.TEST_DATASET1;
import static com.lox.webdriver.Data.TEST_DATASET1_DESCRIPTION;

public class DatasetCreationPage extends BasePage {

    public static final String URL = SITE_URL + "/dataset/new";


    @FindBy(xpath = "html/body/header[2]/div/div/nav/ul/li[1]/a")
    WebElement dataSetsTab;

    @FindBy(xpath = "html/body/div[1]/div/div[3]/div/section[1]/div/div/a")
    WebElement addDatasetButton;

    @FindBy(id = "field-title")
    WebElement datasetTitleField;

    @FindBy(xpath = ".//*[@id='field-notes']")
    WebElement datasetDescriptionField;

    @FindBy(xpath = "html/body/div[1]/div/div[3]/div[2]/section/div/form/div[4]/div/div/ul/li/input")
    WebElement datasetTagsField;

    @FindBy(xpath = ".//*[@id='s2id_field-license']/a/span[2]/b")  //arrowbtn xpath
    WebElement datasetLicenseDropdownButton;

    @FindBy(xpath = ".//*[@class='select2-result-label']") //all list's customized xpath
    List<WebElement> datasetLicenseList;

    @FindBy(xpath = "html/body/div[1]/div/div[3]/div[2]/section/div/form/div[6]/div/div/a/div/b")
    WebElement datasetOrganizationField;

    @FindBy(xpath = ".//*[@class='select2-result-label']")
    List<WebElement> datasetOrganizationList;

    @FindBy(xpath = "html/body/div[1]/div/div[3]/div[2]/section/div/form/div[7]/a")
    WebElement cancelButton;

    @FindBy(xpath = ".//*[@id='content']/div[3]/div/section/div/form/div[6]/button")
    WebElement nextAddDataButton;

    @FindBy(id = "field-url")
    WebElement datasetResourcesField;

    @FindBy(id = "field-name")
    WebElement datasetNameField;

    @FindBy(xpath = "html/body/div[1]/div/div[3]/div[2]/section/div/form/div[4]/div/textarea")
    WebElement datasetAddDataDescriptionField;

    @FindBy(xpath = "html/body/div[1]/div/div[3]/div[2]/section/div/form/div[5]/div/div/a")
    WebElement datasetFormatField;

    @FindBy(xpath = "html/body/div[1]/div/div[3]/div[2]/section/div/form/div[6]/button[1]")
    WebElement datasetPreviousButton;

    @FindBy(xpath = "html/body/div[1]/div/div[3]/div[2]/section/div/form/div[6]/button[2]" )
    WebElement datasetSaveAddAnotherButton;

    @FindBy(xpath = "html/body/div[1]/div/div[3]/div[2]/section/div/form/div[6]/button[3]")
    WebElement datasetCancelButton;

    @FindBy(xpath = ".//*[@id='content']/div[3]/div/section/div/form/div[1]/div/div/button")
    WebElement editButton;

    public DatasetCreationPage(WebDriver driver) {
        super(driver);
    }

    public DatasetCreationPage verifyDatasetPage() {
        return this;
    }

    public DatasetCreationPage createDataSet() {

        datasetTitleField.sendKeys(TEST_DATASET1);
        datasetTitleField.sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("./*//*[@id='field-name']")).sendKeys(TEST_DATASET1);

        datasetDescriptionField.sendKeys(TEST_DATASET1_DESCRIPTION);
        //datasetTagsField.sendKeys(TEST_DATASET1_TAGS);
        //datasetTagsField.sendKeys(Keys.ENTER);


        selectDropdownValue(By.xpath(".//*[@id='s2id_field-license']/a"), "Other (Open)");

        nextAddDataButton.click();

        return this;
    }

    public void selectDropdownValue(By by, String selectValue) {
        driver.findElement(by).click();
        waitForElement(By.xpath(".//*[@id='select2-drop']/div/input"));
        WebElement textField = driver.findElement(By.xpath(".//*[@id='select2-drop']/div/input"));
        textField.sendKeys(selectValue);
        textField.sendKeys(Keys.ENTER);


    }

    public DatasetCreationPage verifyDatasetCreatedSuccessfully() {
        return this;
    }
}
