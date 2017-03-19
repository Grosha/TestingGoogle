package com.apple.tests;

import com.apple.Locators;
import com.apple.Variable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by groshkka on 3/18/17.
 */
public class BaseTestApple implements Locators,Variable{
    public WebDriver browser;


    @BeforeClass
    public void setUp() throws IOException {
        File chromeDriver = new File("/Users/groshkka/Downloads/chromedriver");
        System.setProperty("webdriver.chrome.driver", chromeDriver.getAbsolutePath());
        //open firefox
        //browser = new FirefoxDriver();
        browser = new ChromeDriver();

        //do maximize window browser
        browser.manage().window().maximize();

        //open page on browser
        browser.get(AppleLink);

    }

    //method close browser
    @AfterClass
    public void setDown() {
        browser.close();
        browser.quit();
    }

    //method wait, until items appear
    public void waitElement(By locator) {
        WebDriverWait wait = new WebDriverWait(browser, 15);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement $(By locator) {
        return browser.findElement(locator);
    }

    public List<WebElement> $s(By locator) {
        return browser.findElements(locator);
    }
}
