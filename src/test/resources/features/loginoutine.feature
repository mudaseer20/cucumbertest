@tag
Feature: login to feature

  
  Scenario Outline: login to the ALM application
    Given user in home page
    Given user clicks on privacy policy
    When user clicks on "Yes" button
    Then user closes the child window
      When user switches to "0" window
       Given user clicks on privacy policy
    When user clicks on "Yes" button
    When user switches to "1" window
    When user switches to "0" window
    When the actor clicks on "Login" button
    When user switches to "1" window and closes the window
    When user switches to "0" window
    Then actor enters "<username>"
    When clicks on next button
    Then validate the error message is "<error>"
    
    
  Examples:
  |username | error |
  |hello |Please enter a valid email address|
  

 