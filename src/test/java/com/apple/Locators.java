package com.apple;

import org.openqa.selenium.By;

/**
 * Created by groshkka on 3/18/17.
 */
public interface Locators {
    //toolbar elements locator
    By locatorHomePage = By.cssSelector("#ac-gn-firstfocus");
    By locatorMacPage = By.cssSelector(".ac-gn-link.ac-gn-link-mac");
    By locatorIPadPage = By.cssSelector(".ac-gn-link.ac-gn-link-ipad");
    By locatorIPhonePage = By.cssSelector(".ac-gn-link.ac-gn-link-iphone");
    By locatorWhatchPage = By.cssSelector(".ac-gn-link.ac-gn-link-watch");
    By locatorTVPage = By.cssSelector(".ac-gn-link.ac-gn-link-tv");
    By locatorMusicPage = By.cssSelector(".ac-gn-link.ac-gn-link-music");
    By locatorSupportPage = By.cssSelector(".ac-gn-link.ac-gn-link-support");
    By locatorSearchPage = By.cssSelector(".ac-gn-link.ac-gn-link-search");
    By locatorBagPage = By.cssSelector(".ac-gn-link.ac-gn-link-bag");

    //mac's toolbar
    By lGetToolbarUrl = By.className("chapternav-link");
    By lGetToolbarItems = By.className("chapternav-label");
    By lMacMacbook = By.linkText("MacBook");
    By lMacMacbookAir = By.linkText("MacBook Air");
    By lMacMacbookPro = By.xpath("//span[text()='MacBook Pro']");
    By lMacIMac = By.linkText("iMac");
    By lMacMacPro = By.linkText("Mac Pro");
    By lMacMini = By.linkText("Mac mini");
    By lMacAccessories = By.linkText("Accessories");
    By lMacMacOs = By.linkText("macOS Sierra");
    By lMacCompare = By.linkText("Compare");

    //macbook toolbar
    By lGetToolbarMacbook = By.xpath(".//a[ancestor::div[@class='ac-ln-content']]");
    By lGetToolbarMacbookMacPro = By.xpath(".//a[ancestor::ul[@class='destinations selfclear']]");
    By lGetToolbarMacbookAccessorise = By.className("localnav-disclosure-button hide-outline");

}
