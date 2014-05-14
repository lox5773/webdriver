package com.lox.webdriver.page;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.lox.webdriver.Data.BASE_URL;
import static com.lox.webdriver.Data.DEFAULT_WAIT_SECONDS;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BasePage {


    WebDriver driver;

    BasePage(WebDriver driver){
        this.driver = driver;
    }

    public static final String SITE_URL = BASE_URL;

    @FindBy(xpath = "html/body/header[1]/div/nav/ul/li[1]/a")
    public WebElement loginLink;

    @FindBy(xpath = ".//*[@class='icon-signout']")
    public WebElement logoutLink;

    @FindBy(xpath = "html/body/header[1]/div/nav/ul/li[2]/a")
    public WebElement registerLink;

    @FindBy(xpath = ".//*[@class='username']")
    public WebElement loggedInUserNameLink;

    @FindBy(xpath = "html/body/header[1]/div/div/ul/li[1]/a/span")
    public WebElement headerUsername;

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

    public BasePage verifySuccessLogin(String userFullName) {
        assertThat(loggedInUserNameLink.getText(), is(userFullName));
        return this;
    }

    public BasePage verifyUnsuccessfulLogin() {
        assertThat(loginLink.isDisplayed(), is(true));
        return this;
    }

    public void waitForElement(final By byType){
        waitForElement(byType, DEFAULT_WAIT_SECONDS);
    }

    public void waitForElement(final By byType, int secondsToWait){
        WebDriverWait wait = new WebDriverWait(driver, secondsToWait);
        wait.until(new ExpectedCondition<WebElement>() {

            public WebElement apply(WebDriver webDriver) {
                try
                {
                    return driver.findElement(byType);
                }
                catch (Exception e)
                {
                    return null;
                }
            }
        });
    }

    public BasePage doLogout() {
        try{
            if (logoutLink.isDisplayed()){
                logoutLink.click();
                return PageFactory.initElements(driver, HomePage.class);
            }
        }catch (Exception ex){
            //Do Nothing
        }
        return PageFactory.initElements(driver, LoginPage.class);
    }

    public void selectDropdownValue(By by, String selectValue) {
        driver.findElement(by).click();
        waitForElement(By.xpath(".//*[@id='select2-drop']/div/input"));
        WebElement textField = driver.findElement(By.xpath(".//*[@id='select2-drop']/div/input"));
        textField.sendKeys(selectValue);
        textField.sendKeys(Keys.ENTER);
    }
    
    public void takeScreenShot(String filename)  {
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\screenshots"+filename+".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
