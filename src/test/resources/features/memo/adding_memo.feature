Feature: In this feature we're adding ad to memo as a favorite and checking that it appears to correct

  @smoke
  Scenario: In this scenario user should be able to go to the home url, select a memo and see it as a favorite
    Given user opens home page
    Then logo in header is displayed
    Then user should see ad categories
    |Job and business|
    |Transport|
    |Real estate|
    |Construction|
    |Electronics|
    |Clothes, footwear|
    |Home stuff|
    |Production, work|
    |For children|
    |Animals|
    |Agriculture|
    |Entertainment|
    And click on "Phones" sub category in the "Electronics" section
    And check page title "Phones" and click on item "Apple"
    And user should be able to filter items "iPhone X"
    And user should be able to click on first link
    When user should be able to add item to a favorite
    And get memo's count

  @smoke
  Scenario: In this scenario user should be able add memo using global search
    Given user opens home page
    Then click on global search enter "iPhone" into search field
    And user should be able to click on first link
    When user should be able to add item to a favorite
    And get memo's count

