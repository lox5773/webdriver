package com.lox.webdriver;

import com.lox.webdriver.page.*;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;

import static com.lox.webdriver.Data.*;

public class BaseTest {

    private WebDriver driver;

    @Before
    public void before() {
        String browser = BROWSER_MOZILLA;

        if (BROWSER_MOZILLA.equals(browser)) {
            driver = new FirefoxDriver();
        } else if (BROWSER_IE.equals(browser)){
            driver = new InternetExplorerDriver();
        } else if (BROWSER_CHROME.equals(browser)){
            driver = new ChromeDriver();
        } else {
            driver = new HtmlUnitDriver();
        }
        //Dimension windowSize = driver.manage().window().getSize();
        //driver.manage().window().setPosition(new Point(windowSize.getWidth(), 0));
        //driver.manage().window().setSize(new Dimension(100,100));
    }

    @After
    public void after() {
        driver.close();
    }

    protected HomePage gotoHomePage() {
        driver.get(HomePage.URL);
        return PageFactory.initElements(driver, HomePage.class);
    }

    protected OrganizationPage gotoOrganizationPage() {
        driver.get(OrganizationPage.URL);
        return PageFactory.initElements(driver, OrganizationPage.class);
    }

    protected GroupPage gotoGroupPage() {
        driver.get(GroupPage.URL);
        return PageFactory.initElements(driver, GroupPage.class);
    }

    protected DatasetPage gotoDatasetPage() {
        driver.get(DatasetPage.URL);
        return PageFactory.initElements(driver, DatasetPage.class);
    }

    protected SearchPage gotoSearchPage() {
        driver.get(SearchPage.URL);
        return PageFactory.initElements(driver, SearchPage.class);
    }

    protected LoginPage gotoLoginPage() {
        driver.get(LoginPage.URL);
        return PageFactory.initElements(driver, LoginPage.class);
    }

    protected RegisterPage gotoRegisterPage() {
        driver.get(RegisterPage.URL);
        return PageFactory.initElements(driver, RegisterPage.class);
    }

    protected AboutPage gotoAboutPage() {
        driver.get(AboutPage.URL);
        return PageFactory.initElements(driver, AboutPage.class);
    }


}
