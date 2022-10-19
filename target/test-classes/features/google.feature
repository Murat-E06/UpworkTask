Feature: User wants to search any keyword at Google

  @GoogleTask
  Scenario Outline: User can successfully search a single keyword
    Given user opens "<browser>"
    And user clear "<browser>" cookies
    When user goes to Google
    And user searches using the "<keyword>"" at Google
    And user parses the first 10 search result items at Google
    Then user checks that at least one attribute of each item from parsed search results contains "<keyword>" at Google
    Then user logs in search results whose attributes contain "<keyword>" and whose do not at Google.

    Examples:
      | browser | keyword |
      | chrome  | ruby    |

  @
  Scenario Outline: User can successfully search a single job
    Given user opens "<browser>"
    And user clear "<browser>" cookies
    When user goes to Google
    And user searches using the "<keyword>" at Google

    Examples:
      | browser | keyword |
      | firefox | ruby   |

  @
  Scenario Outline: User can successfully search a single job
    Given user opens "<browser>"
    And user clear "<browser>" cookies
    When user goes to Google
    And user searches using the "<keyword>" at Google
    And user parses the first 10 search result items at Google


    Examples:
      | browser | keyword |
      | chrome | ruby   |

  @
  Scenario Outline: User can successfully search a single job
    Given user opens "<browser>"
    And user clear "<browser>" cookies
    When user goes to Google
    And user searches using the "<keyword>" at Google
    And user parses the first 10 search result items at Google
    Then user checks that at least one attribute of each item from parsed search results contains "<keyword>" at Google


    Examples:
      | browser | keyword |
      | chrome | ruby   |

  @wip
  Scenario Outline: User can successfully search a single job
    Given user opens "<browser>"
    And user clear "<browser>" cookies
    When user goes to Google
    And user searches using the "<keyword>" at Google
    And user parses the first 10 search result items at Google
    Then user checks that at least one attribute of each item from parsed search results contains "<keyword>" at Google
    Then user logs in search results whose attributes contain "<keyword>" and whose do not at Google.


    Examples:
      | browser | keyword |
      | chrome | ruby   |