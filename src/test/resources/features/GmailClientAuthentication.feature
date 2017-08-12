Feature: Authenticate registered user


  @Test-001_01
  Scenario Outline: Verify authentication: user with Inalid Gmail registered account signs in for the first time
    Given I am on Gmail sigIn page
    When I signIn with "<LoginUsername>" and "<LoginPwd>" to authenticate
    Then I should be presented with "<Results>" to indicate successful signIn
    And sign out at the end of my session
    And close browser

    Examples:
      | LoginUsername        | LoginPwd      | Results                           |
      | joe.smith@gmail.com  | secureKong1!  | Couldn't find your Google Account |
      | jane.smith@gmail.com | supersecure3! | Couldn't find your Google Account |
