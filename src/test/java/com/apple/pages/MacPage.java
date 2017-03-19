package com.apple.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by groshkka on 3/19/17.
 */
public class MacPage extends BasePage {
    private static WebElement element = null;

    public static WebElement openSection(WebDriver browser, By section) {
        return element = browser.findElement(section);
    }

    public static void findBrokenLinks(WebDriver browser,By toolbarElements, By listElements) throws MalformedURLException {
        List<ToolbarItem> toolbarItemList = new ArrayList<ToolbarItem>();
        List<String> listToolbarTitle = getToolbarTitle(browser, toolbarElements);

        System.out.println(listToolbarTitle.size());
        for (int i = 0; i < listToolbarTitle.size(); i++) {
            toolbarItemList.add(new ToolbarItem(getListUrl(browser, listElements).get(i), listToolbarTitle.get(i)));
        }

        for (ToolbarItem item : toolbarItemList) {
            if (getResponseCode(item.getUrl()) != true)
                System.out.println(item.getUrl() + " " + item.getItemName() + " url is broken");
            else System.out.println(item.getUrl() + " " + item.getItemName() + " url is correct");
        }
    }

    private static List<String> getToolbarTitle(WebDriver browser, By listElement) {
        List<WebElement> listElementse = new ArrayList<WebElement>();
        listElementse.addAll($s(browser, listElement));

        List<String> listTitle = new ArrayList<String>();
        for (WebElement title : listElementse) {
            listTitle.add(title.getText());
        }

        return listTitle;
    }
}
