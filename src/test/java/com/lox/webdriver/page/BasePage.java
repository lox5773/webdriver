package com.lox.webdriver.page;

import com.google.common.base.Function;
import com.lox.webdriver.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BasePage {

   WebDriver driver;

    BasePage(WebDriver driver){
        this.driver = driver;
    }

    public static final String SITE_URL = Data.SITE_URL;

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
        new WebDriverWait(driver, 10)
                .until(new ExpectedCondition<WebElement>() {

                    @Override
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

    /*public void WaitForElement1(By byType)
    {
        WebDriverWait wait = new WebDriverWait(driver, *//**//*seconds=*//**//*10);
                WebElement myDynamicElement = wait.Until<WebElement>((d) =>
        {
            try
            {
                return d.FindElement(byType);
            }
            catch (Exception e)
            {
                log.Error(e.Message + byType.ToString());
                return null;
            }
        });
    }
    */
    public void waitForElement3(By byType)
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(byType)));
        //wait.until(presenceOfElementLocated(byType));
    }

    Function<WebDriver, WebElement> presenceOfElementLocated(final By locator) {
        return new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        };
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









    /*public static void WaitForElement(By by)
    {
        WebDriverWait wait = new WebDriverWait(driver, TimeSpan.FromSeconds(10));
        wait.Until<bool>((d) =>
            {
        try
        {
            if (d.FindElement(by).Displayed)
                return true;
            else
                return false;
        }
        catch (NoSuchElementException e)
        {
            return false;
        }

        });
    }*/
}
