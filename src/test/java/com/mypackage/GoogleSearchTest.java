package com.mypackage;

import com.mypackage.Pages.MainGooglePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.io.IOException;

public class GoogleSearchTest {
    private WebDriver browser;
    private MainGooglePage mainGooglePage;

    //method of preparing the start page and the browser initializes variables
    @BeforeClass
    public void setUp() throws IOException {
        //open firefox
        browser = new FirefoxDriver();

        //do maximize window browser
        browser.manage().window().maximize();

        //open page on browser
        browser.get(MainGooglePage.startGoogleLink);

        //initialize variable mainGooglePage
        mainGooglePage = new MainGooglePage(browser);
    }

    //get data from console
    @Parameters({"query"})
    @Test
    public void testing(String query) throws InterruptedException, IOException {
        //mainGooglePage.getTitlePage();

        //method check, that opens google search page
        mainGooglePage.checkStartGoogle();

        //method write and search data in google
        mainGooglePage.searchDataInGoogle(query);

        //method, which opens new page, displays title and back to google page
        mainGooglePage.openMewLink();
    }

    //method close browser
    @AfterClass
    public void setDown(){
        browser.close();
        browser.quit();
    }
}
