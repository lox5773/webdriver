package com.lox.webdriver;

import com.lox.webdriver.page.HomePage;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseTest {

    private WebDriver driver;

    @Before
    public void before() {
        String browser = "Mozilla";

        if (browser.equals("Mozilla")) {
            //FirefoxProfile firefoxProfile = new FirefoxProfile();
            //driver = new FirefoxDriver(firefoxProfile);
            driver = new FirefoxDriver();
        } else if (browser.equals("IE")) {
            driver = new InternetExplorerDriver();
        } else if (browser.equals("Chrome")) {
            driver = new ChromeDriver();
        }

    }

    @After
    public void after() {
        driver.close();
    }

    protected HomePage gotoHomePage() {
        driver.get(HomePage.URL);
        return PageFactory.initElements(driver, HomePage.class);
    }
}
