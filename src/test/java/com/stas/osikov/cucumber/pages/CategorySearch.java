package com.stas.osikov.cucumber.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractionSteps;

import java.util.List;
import java.util.stream.Collectors;

public class CategorySearch extends UIInteractionSteps {

    public List<String> titles() {
        waitABit(2000);
        return findAll(HomePage.RESULT_SEARCH)
                .stream()
                .map(WebElementFacade::getTextContent)
                .filter(text -> !text.equalsIgnoreCase("Ad"))
                .collect(Collectors.toList());
    }
}
