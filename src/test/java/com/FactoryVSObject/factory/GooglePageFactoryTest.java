package com.FactoryVSObject.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class GooglePageFactoryTest {
    private WebDriver browser;
    private static final String startGoogleLink = "https://www.google.com.ua/";

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/groshkka/PycharmProjects/selenium/chromedriver");
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get(startGoogleLink);
    }

    @Test
    public void testPageFactory() {
        GooglePageFactoryHelper factoryHelper = PageFactory.initElements(browser, GooglePageFactoryHelper.class);
        factoryHelper.findPage("Halle Berry");

        String s = "https://en.wikipedia.org/wiki/Halle_Berry";
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        assertEquals(browser.getCurrentUrl(), s);
    }

    @AfterTest
    public void setDown() {
        browser.close();
        browser.quit();
    }
}
