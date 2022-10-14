Feature: User wants to search keyword at Google

@GoogleTask
  Scenario Outline: User can successfully search a single job
    Given user opens <browser>
    And user clear <browser> cookies
    When user goes to Google
    And user searches using the <keyword> at Google
    And user parses the first 10 search result items at Google
    Then user checks that at least one attribute of each item from parsed search results contains <keyword> at Google
    Then user logs in search results whose attributes contain <keyword> and which do not at Google.

    Examples:
      | browser | keyword |
      | chrome  | ruby    |

  @wip
  Scenario Outline: User can successfully search a single job
    Given user opens <browser>
    And user clear <browser> cookies
    When user goes to Google
    And user searches using the <keyword> at Google

    Examples:
      | browser | keyword |
      | chrome  | ruby    |