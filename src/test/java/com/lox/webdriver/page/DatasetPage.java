package com.lox.webdriver.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DatasetPage extends BasePage {

    public static final String URL = SITE_URL + "/dataset";


    @FindBy(xpath = "html/body/header[2]/div/div/nav/ul/li[1]/a")
    WebElement dataSetsTab;

    @FindBy(xpath = "html/body/div[1]/div/div[2]/div/a")
    WebElement addDatasetButton;

    @FindBy(id = "field-title")
    WebElement datasetTitleField;

    @FindBy(xpath = "html/body/div[1]/div/div[3]/div[2]/section/div/form/div[3]/div/textarea")
    WebElement datasetDescriptionField;

    @FindBy(xpath = "html/body/div[1]/div/div[3]/div[2]/section/div/form/div[4]/div/div/ul/li/input")
    WebElement datasetTagsField;

    @FindBy(xpath = "html/body/div[1]/div/div[3]/div[2]/section/div/form/div[5]/div/div/a/div/b")  //arrowbtn xpath
    WebElement datasetLicenseField;

    @FindBy(xpath = ".//*[@class='select2-result-label']") //all list's customized xpath
    List<WebElement> datasetLicenseList;

    @FindBy(xpath = "html/body/div[1]/div/div[3]/div[2]/section/div/form/div[6]/div/div/a/div/b")
    WebElement datasetOrganizationField;

    @FindBy(xpath = ".//*[@class='select2-result-label']")
    List<WebElement> datasetOrganizationList;

    @FindBy(xpath = "html/body/div[1]/div/div[3]/div[2]/section/div/form/div[7]/a")
    WebElement cancelButton;

    @FindBy(xpath = "html/body/div[1]/div/div[3]/div[2]/section/div/form/div[7]/button")
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

    public DatasetPage(WebDriver driver) {
        super(driver);
    }

    public DatasetPage verifyDatasetPage() {
        return this;
    }

    public void createDataSet() throws InterruptedException{

       /* WebDriverWait wait = new WebDriverWait(driver, 20);

        dataSetsTab.click();
        addDatasetButton.click();
        datasetTitleField.sendKeys(TEST_DATASET1);
        datasetDescriptionField.sendKeys(TEST_DATASET1_DESCRIPTION);
        datasetTagsField.sendKeys(TEST_DATASET1_TAGS);
        datasetTagsField.sendKeys(Keys.ENTER);
        datasetLicenseField.click();

        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[3]/ul")));

        List<WebElement> options = datasetLicenseList;
        for (WebElement option : options) {

            if(config.getProperty("datasetLicense").equals(option.getText())){
                option.click();
                System.out.println("Clicking");
                driver = getDriver();
            }
        }

        System.out.println("THERE");
		*//*List<WebElement> options = driver.findElements(By.xpath("./*//*[@class='select2-result-label']"));
		for (WebElement option : options) {
	        if("Other (Not Open)".equals(option.getText()))
	            option.click();*//*

        datasetOrganizationField.click();
        List<WebElement> orgOptions = datasetOrganizationList;
        for(WebElement orgOption : orgOptions){
            Thread.sleep(3000);
            if(config.getProperty("datasetOrganization").equals(orgOption.getText()));
            orgOption.click();

        }*/

    }
}
