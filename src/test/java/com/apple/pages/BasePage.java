package com.apple.pages;

import com.apple.Locators;
import com.apple.Variable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.net.ssl.HttpsURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by groshkka on 3/19/17.
 */
public class BasePage implements Locators, Variable {

    public static boolean getResponseCode(URL url) {
        boolean isValid = true;
        try {
            HttpsURLConnection h = (HttpsURLConnection) url.openConnection();
            h.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.1; en-GB;" +
                    "     rv:1.9.2.13) Gecko/20101203 Firefox/3.6.13 (.NET CLR 3.5.30729)");
            h.connect();
            System.out.println(h.getResponseCode());
            //System.out.println(h.getResponseMessage());
            if (h.getResponseCode() != 200) {
                isValid = false;
            }
        } catch (Exception e) {

        }
        return isValid;
    }

    public WebElement $(WebDriver browser, By locator) {
        return browser.findElement(locator);
    }

    public static List<WebElement> $s(WebDriver browser, By locator) {
        return browser.findElements(locator);
    }

    public static List<URL> getListUrl(WebDriver browser, By lListElements) throws MalformedURLException {

        List<WebElement> listElements = new ArrayList<WebElement>();
        listElements.addAll($s(browser, lListElements));

        List<URL> listUrl = new ArrayList<URL>();
        for (WebElement el : listElements) {
            if (el.getAttribute("href") != null)
                listUrl.add(new URL(AppleLink + el.getAttribute("href")));
        }
        return listUrl;
    }
}
