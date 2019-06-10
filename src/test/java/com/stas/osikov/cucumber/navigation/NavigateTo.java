package com.stas.osikov.cucumber.navigation;

import net.thucydides.core.annotations.Step;

public class NavigateTo {

    private BasePage adBoardHomePage;

    @Step("Open ad board home page")
    public void theAdBoardHomePage() {
        adBoardHomePage.open();
    }
}
