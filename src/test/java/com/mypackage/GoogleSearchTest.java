package com.mypackage;

import com.mypackage.Pages.GooglePage;
import org.testng.annotations.*;

import java.io.IOException;

public class GoogleSearchTest extends GooglePage {
    //get data from console
    @Parameters({"query"})
    @Test
    public void testing(String query) throws InterruptedException, IOException {
        //method check, that opens google search page
        checkStartGoogle("Google");

        //method write and search data in google
        searchDataInGoogle(query);

        //method, which opens new page, displays title and back to google page
        openNewLink();
    }


}
