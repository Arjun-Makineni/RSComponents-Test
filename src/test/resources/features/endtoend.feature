#@sanity
Feature: Search for a product and add the item to the basket

  Scenario: User is able to search by a keyword
    Given the user is on homepage
    When user searches for batteries
    Then search results page displayed

  Scenario: User is able to search by a keyword and then filter
    Given the user is on homepage
    When user searches for wires
    And select from category index 1 and sub index 3
    Then product listings page with filters displayed
