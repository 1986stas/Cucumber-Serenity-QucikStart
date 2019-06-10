package com.stas.osikov.cucumber.pages;

import com.stas.osikov.cucumber.navigation.BasePage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class CategoryPage extends BasePage {

    private WebElementFacade addToFavoriteItem = find(By.xpath("//td[@valign = 'bottom']/descendant-or-self::a[contains (text(), 'Add to favorites')]"));

    @Step("Get string page title to make sure that user is on the right page")
    public String getPageName(){
        return $(By.xpath("//div[@class = 'top_head']/descendant-or-self::a")).getText();
    }

    @Step("Click on specific item after choosing category on home page")
    public void clickOnCategoryItem(String itemName){
        $(By.xpath("//*[@id = 'page_main']/descendant-or-self::a[contains (text(), '$1')]"
                .replace("$1", itemName))).click();
    }

    @Step("Filter items to display specific")
    public void filterItems(String filterValue) {
        moveTo("//select[@class = 'filter_sel']").click();
        findWebElementAndClickOnIt(filterValue, findAll(By.xpath("//select[@class = 'filter_sel']/option")));
    }

    @Step("In this step we just want to make sure that user is able to click on first link")
    public void clickOnFirstRandomLink(){
        moveTo(By.xpath("//table//tbody//tr[contains (@id, 'tr')][1]")).click();
    }

    @Step("Check that add to favorites item is presented")
    public boolean isAddToFavoritesDisplayed() {
        scrollIntoView();
        return  addToFavoriteItem.isPresent();
    }

    @Step("User clicks on item add to favorite")
    public void addItemToFavorite(){
        moveTo("//td[@valign = 'bottom']/descendant-or-self::a[contains (text(), 'Add to favorites')]").click();
    }
}
