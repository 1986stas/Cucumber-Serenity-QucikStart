package com.stas.osikov.cucumber.navigation;

import org.openqa.selenium.WebDriver;

public class WebBrowser {

    private static volatile WebDriver instance;

    public static void tearDown() {
        if (instance!= null) {
            instance.quit();
            instance.manage().deleteAllCookies();
            instance = null;
        }
    }

}
