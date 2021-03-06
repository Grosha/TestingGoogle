package com.apple.tests;

import com.apple.pages.MacPage;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.Screenshot;

import java.io.IOException;
import java.net.MalformedURLException;

import static org.testng.Assert.assertEquals;

/**
 * Created by groshkka on 3/19/17.
 */
public class MacPageTest extends BaseTestApple {
    @Test
    public void checkToolbarLinks() throws MalformedURLException {
        waitElement(locatorMacPage);
        MacPage.openSection(browser, locatorMacPage).click();
        waitElement(lGetToolbarUrl);
        MacPage.findBrokenLinks(browser, lGetToolbarItems, lGetToolbarUrl);
    }

    @DataProvider(name = "macToolbarSections")
    public static Object[][] toolbarName() {
        return new Object[][]{
                {lMacMacbook, titleMacbook, true, lGetToolbarMacbook},
                {lMacMacbookAir, titleMacbookAir, true, lGetToolbarMacbook},
                {lMacMacbookPro, titleMacbookPro, true, lGetToolbarMacbook},
                {lMacIMac, titleMacbookiMac, true, lGetToolbarMacbook},
                {lMacMacPro, titleMacbookMacPro, true, lGetToolbarMacbookMacPro},
                {lMacMini, titleMacbookMacMini, true, lGetToolbarMacbook},
                {lMacAccessories, titleMacbookAccesspories, false, lGetToolbarMacbookAccessorise},
                {lMacMacOs, titleMacbookOS, true, lGetToolbarMacbook},
                {lMacCompare, titleMacbookCompare, false, lGetToolbarMacbook},
        };
    }

    @Test(dataProvider = "macToolbarSections")
    public void openMacToolbar(By section, String titlePage, boolean tbIsTrue, By lToolbar) throws IOException, InterruptedException {
        Thread.sleep(200);
        waitElement(locatorMacPage);
        MacPage.openSection(browser, locatorMacPage).click();
        waitElement(section);
        MacPage.openSection(browser, section).click();
        assertEquals(browser.getTitle(), titlePage);
        if (tbIsTrue == true) {
            waitElement(lToolbar);
            MacPage.findBrokenLinks(browser, lToolbar, lToolbar);
            saveStandardScreen("standard" + titlePage + "Toolbar", createScreenOneElement(lGetToolbarMacbook_));
        }
    }

    @Test
    public void checkScreenshotMacPageToolbar() throws IOException, InterruptedException {
        waitElement(locatorMacPage);
        MacPage.openSection(browser, locatorMacPage).click();

        Screenshot standardScreenshot = getScreenshot("standardMacPageToolbar.png");
        Screenshot newScreenshot = createScreenOneElement(lGetToolbar);
        saveNewScreen("newMacPageToolbar", newScreenshot);
        saveResult(standardScreenshot, newScreenshot, "MacPageToolbarResult");
    }

    @Test
    public void checkScreenshotMacBookPageToolbar() throws IOException, InterruptedException {
        waitElement(locatorMacPage);
        MacPage.openSection(browser, locatorMacPage).click();
        waitElement(lMacMacbook);
        MacPage.openSection(browser, lMacMacbook).click();

        Screenshot standardScreenshot = getScreenshot("standardMacPageToolbar.png");
        Screenshot newScreenshot = createScreenOneElement(lGetToolbar);
        saveNewScreen("newMacPageToolbar", newScreenshot);
        saveResult(standardScreenshot, newScreenshot, "MacPageToolbarResult");
    }

}
