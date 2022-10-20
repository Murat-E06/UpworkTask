Feature: Compare google and bing search result

  @compare
  Scenario Outline: User can successfully search a single job
    Given user opens "<browser>"
    And user clear "<browser>" cookies
    When user goes to Google
    And user searches using the "<keyword>" at Google
    And user parses the first 10 search result items at Google
    Then user checks that at least one attribute of each item from parsed search results contains "<keyword>" at Google
    Then user logs in search results whose attributes contain "<keyword>" and whose do not at Google.
    When user goes to Bing
    And user searches using the "<keyword>" at Bing
    And user parses the first 10 search result items at Bing
    Then user checks that at least one attribute of each item from parsed search results contains "<keyword>" at Bing
    Then user logs in search results whose attributes contain "<keyword>" and whose do not at Bing
    Then User compares results and lists most popular items

    Examples:
      | browser | keyword |
      | firefox | cucumber   |