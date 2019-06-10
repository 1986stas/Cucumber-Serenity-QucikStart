package com.stas.osikov.cucumber.navigation;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.stream.Collectors;

public class BasePage extends PageObject {

    private static final int TIME_TO_WAIT = 5000;

    private Actions actions;

    protected <T extends List<WebElementFacade>> void findWebElementAndClickOnIt(String item, T t) {
        t.stream().filter(webElementFacade -> webElementFacade.getValue().equalsIgnoreCase(item))
                .forEach(webElementFacade -> webElementFacade.waitUntilVisible().click());
    }

    protected List<String> getListOfObjects(By by){
        return findAll(by).stream().
                map(WebElementFacade::getText).
                collect(Collectors.toList());
    }

    protected void scrollIntoView() {
        actions = new Actions(getDriver());
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();
    }

    protected void tapNameButtonOnKeyboard(String keyName) {
        actions = new Actions(getDriver());
        switch (keyName.toLowerCase()) {
            case "up": {
                actions.sendKeys(Keys.ARROW_UP).build().perform();
                break;
            }
            case "down": {
                actions.sendKeys(Keys.ARROW_DOWN).build().perform();
                break;
            }
            case "enter": {
                actions.sendKeys(Keys.ENTER).build().perform();
                break;
            }
            case "tab": {
                actions.sendKeys(Keys.TAB).build().perform();
                break;
            }
            case "end": {
                actions.sendKeys(Keys.END).build().perform();
                break;
            }
        }
    }
}
