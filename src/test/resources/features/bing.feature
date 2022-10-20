Feature: User wants to search any keyword at Bing

  @Bing1
  Scenario Outline: User can successfully search a keyword
    Given user opens "<browser>"
    And user clear "<browser>" cookies
    When user goes to Bing
    And user searches using the "<keyword>" at Bing
    And user parses the first 10 search result items at Bing
    Then user checks that at least one attribute of each item from parsed search results contains "<keyword>" at Bing
    Then user logs in search results whose attributes contain "<keyword>" and whose do not at Bing

    Examples:
      | browser | keyword |
      | firefox  | ruby    |

  @Bing2
  Scenario Outline: User can successfully search a keyword
    Given user opens "<browser>"
    And user clear "<browser>" cookies
    When user goes to Bing
    And user searches using the "<keyword>" at Bing
    And user parses the first 10 search result items at Bing
    Then user checks that at least one attribute of each item from parsed search results contains "<keyword>" at Bing
    Then user logs in search results whose attributes contain "<keyword>" and whose do not at Bing

    Examples:
      | browser | keyword |
      | chrome  | ruby    |