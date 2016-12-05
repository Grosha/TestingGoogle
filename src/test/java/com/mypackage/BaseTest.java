package com.mypackage;

import com.mypackage.Pages.GooglePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class BaseTest {

    public WebDriver browser;
    public GooglePage googlePage;
    private static final String startGoogleLink = "https://www.google.com.ua/";

    @BeforeClass
    public void setUp() throws IOException {
        //File chromeDriver = new File("/home/groshkka/Downloads/geckodriver");
        //System.setProperty("webdriver.gecko.driver", chromeDriver.getAbsolutePath());
        //open firefox
        browser = new FirefoxDriver();

        //do maximize window browser
        browser.manage().window().maximize();

        //open page on browser
        browser.get(startGoogleLink);

    }

    //method close browser
    @AfterClass
    public void setDown() {
        browser.close();
        browser.quit();
    }

    //method wait, until items appear
    public void waitElement(By locator) {
        WebDriverWait wait = new WebDriverWait(browser, 10);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement $(By locator) {
        return browser.findElement(locator);
    }
}
