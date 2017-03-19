package com.apple.pages;

import java.net.URL;

/**
 * Created by groshkka on 3/19/17.
 */
public class ToolbarItem {
    private URL url;
    private String itemName;

    public ToolbarItem(URL url, String itemName) {
        this.url = url;
        this.itemName = itemName;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
