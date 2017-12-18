package com.FactoryVSObject.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class GooglePageObjectTest {
    private WebDriver browser;
    private GooglePageObjectHelper pageObjectHelper;
    private static final String startGoogleLink = "https://www.google.com.ua/";

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/groshkka/PycharmProjects/selenium/chromedriver");
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get(startGoogleLink);
    }



    @Test
    public void testPageObject() {
        pageObjectHelper = new GooglePageObjectHelper(browser);
        pageObjectHelper.findSearchField().sendKeys("Halle Berry", Keys.ENTER);

        String s = "https://en.wikipedia.org/wiki/Halle_Berry";
        pageObjectHelper.findURLAtPage(By.linkText("Halle Berry - Wikipedia")).click();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        assertEquals(browser.getCurrentUrl(), s);
    }

    @Test
    public void testPageObject_() {
        pageObjectHelper = new GooglePageObjectHelper(browser);
        pageObjectHelper.openPage("Halle Berry");

        String s = "https://en.wikipedia.org/wiki/Halle_Berry";
        assertEquals(browser.getCurrentUrl(), s);
    }

    @AfterMethod
    public void setUpPage(){
        browser.navigate().to(startGoogleLink);
    }

    @AfterTest
    public void setDown() {
        browser.close();
        browser.quit();
    }
}
