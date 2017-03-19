package com.apple.tests;

import com.apple.Locators;
import com.apple.pages.HomePage;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by groshkka on 3/18/17.
 */
public class HomePageTest extends BaseTestApple {

    @DataProvider(name = "toolbarSections")
    public static Object[][] toolbarName() {
        return new Object[][]{
                {locatorHomePage, titleToolbarHome},
                {locatorMacPage, titleToolbarMac},
                {locatorIPadPage, titleToolbariPad},
                {locatorIPhonePage, titleToolbariPhone},
                {locatorWhatchPage, titleToolbarWatch},
                {locatorTVPage, titleToolbarTV},
                {locatorMusicPage, titleToolbarMusic},
                {locatorSupportPage, titleToolbarSupport},
        };
    }

    @Test(dataProvider = "toolbarSections")
    public void testOpenToolbarSection(By section, String titlePage) {
        waitElement(section);
        HomePage.openSection(browser, section).click();
        waitElement(section);
        assertEquals(browser.getTitle(), titlePage);
    }
}
