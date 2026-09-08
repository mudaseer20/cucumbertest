# Author: your.email@your.domain.com
# Keywords Summary :
# Feature: List of scenarios.
# Scenario: Business rule through list of steps with arguments.
# Given: Some precondition step
# When: Some key actions
# Then: To observe outcomes or validation
# And,But: To enumerate more Given,When,Then steps
# Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
# Examples: Container for s table
# Background: List of steps run before each of the scenarios
# """ (Doc Strings)
# | (Data Tables)
# @ (Tags/Labels):To group Scenarios
# <> (placeholder)
# ""
# # (Comments)
# Sample Feature Definition Template

Feature: login to feature

  Background:
    Given user in home page
      
      
@staging
  Scenario: login to the ALM application

    Given user clicks on privacy policy
    When user clicks on "Yes" button
    Then user clicks on about Icertis button
    When user clicks on "Yes" button
    Then user closes the child window
    When user switches to "0" window
    When user clicks on privacy policy
    When user clicks on "Yes" button
    When user switches to "1" window
    When user switches to "0" window
    When the actor clicks on "Login" button
    When user switches to "1" window and closes the window
    When user switches to "0" window
    Then actor enters "hello"
    When clicks on next button
    Then validate the error message is "Please enter a valid email address"
    Then user clears the value in the text box
    Then actor enters "hello@gmail.com"
    # And click on login button
    # When user enters username
    And clicks on next button
    Then user enters username as "SA_IDN6@icertisclmaad.onmicrosoft.com"
    And clicks on next button in sign in page
    And actor enters password "24Jun@2026IDN1"
    And actor clicks on sign in button
    And user clicks on enter button
        Then user validates the text below Your organization
      | My Tasks       |
      | Customers     |
      | Users          |
      | Instances      |
      | Extensions     |
      | Deployments    |
      | Certifications |
        Then validate the below the menu
      | Home       |
      | My Tasks     |
      | Administer        |
      | Develop     |
      | Implement & Support     |
      | SKUs   |
   
  

     And user gets the title of the page
     And insert the values of the your organisation
 
     
     When user clicks on IS Button
      | Role: Portal Admin | SA_IDN6@icertisclmaad.onmicrosoft.com|
      Then user clicks on "Administer" button in the menu
      Then user validates the text below "Administer" menu
        | Roles    |
      | Partners    |
      | Customers        |
      | Users    |
      
        Then user clicks on "Develop" button in the menu
      Then user validates the text below "Develop" menu
        | Workbench  |
      | Extensions   |
      | Certifications      |
      
             Then user clicks on "Implement & Support" button in the menu
      Then user validates the text below "Implement & Support" menu
        | Instances  |
      | Deployments   |
      | Vera Dashboard     |
               Then user clicks on "SKUs" button in the menu
      Then user validates the text below "SKUs" menu
        | Product Catalog  |
      | Requests   |
      | Deployments    |
  

  
      

      
 
  @prod
  Scenario:invalid login
  
     When the actor clicks on "Login" button
     And clicks on next button
     Then validate the error message is "Please enter a valid email address"