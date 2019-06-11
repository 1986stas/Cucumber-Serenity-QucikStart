package com.stas.osikov.cucumber.stepdefinitions;

import com.stas.osikov.cucumber.matchers.TextMatcher;
import com.stas.osikov.cucumber.navigation.NavigateTo;
import com.stas.osikov.cucumber.navigation.WebBrowser;
import com.stas.osikov.cucumber.pages.CategoryPage;
import com.stas.osikov.cucumber.pages.CategorySearch;
import com.stas.osikov.cucumber.pages.HomePage;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AdBoardStepDefinitions {

    @Steps
    NavigateTo navigateTo;
    @Steps
    HomePage homePage;
    @Steps
    CategorySearch categorySearch;
    @Steps
    CategoryPage categoryPage;

    @Given("user opens home page")
    public void userOpensHomePage() {
        navigateTo.theAdBoardHomePage();
    }

    @Then("logo in header is displayed")
    public void logoInHeaderIsDisplayed() {
        assertThat(homePage.isLogoDisplayed()).isTrue();
    }

    @Then("user should see ad categories")
    public void userShouldSeeAdCategories(List<String> getExpectedCategories) {
        assertThat(getExpectedCategories).isEqualTo(homePage.getActualListOfTitles());
    }

    @And("click on {string} sub category in the {string} section")
    public void clickOnSubCategoryInTheSection(String subCategory, String category) {
        homePage.clickOnCategory(subCategory, category);
    }


    @And("check page title {string} and click on item {string}")
    public void checkPageTitleAndClickOnItem(String pageName, String item) {
        assertThat("Page is wrong", pageName, is(equalTo(categoryPage.getPageName())));
        categoryPage.clickOnCategoryItem(item);
    }

    @And("user should be able to filter items {string}")
    public void userShouldBeAbleToFilterItems(String itemToFilter) {
        categoryPage.filterItems(itemToFilter);
    }

    @And("user should be able to click on first link")
    public void userShouldBeAbleClickOnFirstLink() {
        categoryPage.clickOnFirstRandomLink();
    }

    @When("user should be able to add item to a favorite")
    public void userShouldBeAbleToAddItemToAFavorite() {
        categoryPage.addItemToFavorite();
    }

    @And("get memo's count")
    public void getMemoSCount() {
        assertThat(homePage.getMemoCount(), is(equalTo(1)));
    }

    /**
     * in the tests below I'm checking global search
     */
    @Then("click on global search enter {string} into search field")
    public void clickOnGlobalSearchEnterIntoSearchField(String value) {
        homePage.clickOnTopHeaderMenuItem("Search")
                .enterText(value);
        assertThat(categorySearch.titles())
                .allMatch(title -> TextMatcher.textOf(title).containsIgnoringCase(value));
        homePage.submit();
    }

    @After
    public void cleanUp(){
        WebBrowser.tearDown();
    }
}
