package com.FactoryVSObject.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class GooglePageObjectHelper {

    private WebDriver driver;
    private final By locatorSearchField = By.id("lst-ib");

    public GooglePageObjectHelper(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement findSearchField() {
        return driver.findElement(locatorSearchField);
    }

    public WebElement findURLAtPage(By by) {
        return driver.findElement(by);
    }

    public void openPage(String query){
        findSearchField().sendKeys(query, Keys.ENTER);
        findURLAtPage(By.linkText("Halle Berry - Wikipedia")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
