#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Login Feature

  Scenario: Login as user
    Given User is on homepage
    When user navigates to homepage
    And user enters username and password
    Then success message is displayed
 
 
 Scenario:Login as user
  Given User is at homepage
    When user navigate to homepage
    And user enter username and password
    Then Failure message is displayed
   
 Scenario:Creating new account
   Given User is in homepage
   When User clicked on signin
   And User enters emailId and clicked on Createaccount button
   Then Create An Account page is displayed 
   
  Scenario:Validating if user is able to sort as per requirement
    Given: User is landed on homepage
    When  User searched for dresses
    And  Sort By dropdown box appeared and selected option
    Then items displayed as per choice made
