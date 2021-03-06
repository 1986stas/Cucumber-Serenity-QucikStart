package com.stas.osikov.cucumber.matchers;

public class TextMatcher {

    private String text;

    private TextMatcher(String text) {
        this.text = text;
    }

    public static TextMatcher textOf(String text) {
        return new TextMatcher(text);
    }

    public boolean containsIgnoringCase(String expectedText) {
        return text.toLowerCase().contains(expectedText.toLowerCase());
    }
}
