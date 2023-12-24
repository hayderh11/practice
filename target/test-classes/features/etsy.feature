@EstySearch @smokeTest @Regression
Feature: User is able to search items

@etsySearchTest
  Scenario Outline: Search items on etsy
    Given I am on the homepage
    When I search "<items>"
    Then I should see the search item "<items>" on the result page
    And the page title should contain the searched item "<items>"

    Examples: 
      | items        |
      | Coffee Mug   |
      | Soccer ball  |
      | Window tints |
      | Punching bag |
