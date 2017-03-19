package com.apple.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by groshkka on 3/18/17.
 */
public class HomePage {
    private static WebElement element = null;

    public static WebElement openSection(WebDriver browser, By section) {
        return element = browser.findElement(section);
    }
}
