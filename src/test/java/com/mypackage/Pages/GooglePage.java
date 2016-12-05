package com.mypackage.Pages;

import com.mypackage.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class GooglePage extends BaseTest {
    public static final By searchLocator = By.id("lst-ib");
    public static final By locatorStartSearch = By.name("btnG");
    public static final By locatorAllLink = By.xpath(".//*[@id='rso']//h3/a");

    //method write and search data in google
    public void searchDataInGoogle(String data) {
        $(searchLocator).clear();
        //write data
        $(searchLocator).sendKeys(data);
        //click button  Search
        $(locatorStartSearch).click();
        //wait until items appear
        waitElement(locatorAllLink);
    }

    //check, that opens google search page
    public void checkStartGoogle(String title) {
        assertEquals(browser.getTitle(), title);
    }


    //method, which give list webelements
    public List<WebElement> getListWebElement() {
        return browser.findElements(locatorAllLink);
    }

    //method, which give String list with title page
    public List<String> getListLink() {
        ArrayList<String> linkList = new ArrayList<String>();
        for (int i = 0; i < getListWebElement().size(); i++) {
            linkList.add(getListWebElement().get(i).getText());
        }
        return linkList;
    }

    //method, which print all title page
    public void printAllLinks() {
        for (int i = 0; i < getListLink().size(); i++) {
            System.out.println(getListLink().get(i));
        }
    }

    //method, which opens new page, displays title and back to google page
    public void openNewLink() throws InterruptedException {
        //check, that google find links
        if (getListLink().size() != 0) {
            //a cycle of length list of links
            //for (int i = 0; i < getListLink().size(); i++) {
                //variable with title page's
                String locator = getListLink().get(0);

                //go to new page
                $(By.linkText(locator)).click();
                //Assert.assertEquals(driver.getTitle(),locator);

                //wait
                browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

                //display title
                System.out.println(browser.getTitle());

                //sleep
                Thread.sleep(750);

                //back to the google page
                browser.navigate().back();

                //wait
                browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //}
        }
    }


}
