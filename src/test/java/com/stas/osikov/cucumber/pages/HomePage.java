package com.stas.osikov.cucumber.pages;

import com.stas.osikov.cucumber.navigation.BasePage;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

import java.util.List;

public class HomePage extends BasePage {

    private static By SEARCH_FIELD = By.xpath("//*[contains (text(), 'Ought word or phrase')]/following::input[@type = 'text']");
    private static By SEARCH_BUTTON = By.xpath("//*[contains (text(), 'Ought word or phrase')]/following::input[@type = 'submit']");
    static By RESULT_SEARCH = By.xpath("//div[@id = 'preload_txt']/div");
    private static By RESULT_TITLES = By.xpath("//div[@id = 'page_main_full']/descendant-or-self::*[@class = 'main_head']//a");


    @Step("Get titles on Ad Board home page")
    public List<String> getActualListOfTitles(){
        return getListOfObjects(RESULT_TITLES);
    }

    @Step("Check if logo is displayed")
    public boolean isLogoDisplayed(){
        return  $(By.xpath("//span[@class = 'page_header_head']")).isDisplayed();
    }

    @Step("Click on sub category")
    public void clickOnCategory(String subCategory, String category){
        $(By.xpath("//*[contains (text(), '$1')]/ancestor::div[contains (@id, 'dv')]/descendant-or-self::*[@class = 'main_category']/a[contains (text(), '$2')]"
                .replace("$1", category).replace("$2", subCategory)))
                .waitUntilClickable().click();
    }

    /**
     *
     * @param headerMenuItem menu item name to click
     * @return instance of page
     */
    @Step("Click on header menu item")
    public HomePage clickOnTopHeaderMenuItem(String headerMenuItem){
        $(By.xpath("//span[@class = 'page_header_menu']/descendant-or-self::*[contains (text(), '$1')]"
                .replace("$1", headerMenuItem))).click();
        return this;
    }

    @Step("Value to enter into search field")
    public HomePage enterText(String value){
        term(value);
        return this;
    }

    @Step("Submit search after entering")
    public HomePage submit(){
        tapNameButtonOnKeyboard("Enter");
        return this;
    }

    @Step("Search for term {0}")
    private void term(String term) {
        $(SEARCH_FIELD).clear();
        $(SEARCH_FIELD).type(term);
    }

    @Step("Get count of favorites item added by user")
    public Integer getMemoCount(){
        return Integer.valueOf($(By.xpath("//span[@class = 'page_header_menu']/descendant-or-self::span[@id = 'mnu_fav_id']")).getText()
                .replace("(", "").replace(")", "").replace(" ", ""));
    }


}
