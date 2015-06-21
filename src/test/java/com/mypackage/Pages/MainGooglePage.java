package com.mypackage.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainGooglePage {
    private final WebDriver driver;
    public static final String startGoogleLink = "https://www.google.com.ua/";
    public static final By searchLocator = By.id("lst-ib");
    public static final By locatorStartSearch = By.name("btnG");
    public static final By locatorAllLink = By.xpath(".//*[@id='rso']//h3/a");

    //constructor
    public MainGooglePage(WebDriver driver) {
        this.driver = driver;
    }

    //method write and search data in google
    public void searchDataInGoogle(String data) {
        //write data
        driver.findElement(searchLocator).sendKeys(data);

        //click button  Search
        driver.findElement(locatorStartSearch).click();

        //wait until items appear
        waitElement(locatorAllLink);
    }

    //check, that opens google search page
    public void checkStartGoogle() {
        Assert.assertEquals(driver.getTitle(), "Google");
    }

    //method wait, until items appear
    public void waitElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    //method, which give list webelements
    public List<WebElement> getListWebElement() {
        return driver.findElements(locatorAllLink);
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
    public void openMewLink() throws InterruptedException {
        //check, that google find links
        if (getListLink().size() != 0) {
            //a cycle of length list of links
            for (int i = 0; i < getListLink().size(); i++) {
                //variable with title page's
                String locator = getListLink().get(i);

                //go to new page
                driver.findElement(By.linkText(locator)).click();
                //Assert.assertEquals(driver.getTitle(),locator);

                //wait
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

                //display title
                System.out.println(driver.getTitle());

                //sleep
                Thread.sleep(750);

                //back to the google page
                driver.navigate().back();

                //wait
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            }
        }
    }
}
