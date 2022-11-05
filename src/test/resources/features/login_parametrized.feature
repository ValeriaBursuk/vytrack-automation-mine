@smoke
Feature: User should be able to login
  User Story:
  As a user, I should be able to login to VyTrack application with valid credentials to different accounts. And Dashboard options should be displayed
  Accounts are: driver, sales manager, storemanager.


  Background:
    Given user is on the login page

  Scenario: Login as a driver
    When user enters "truck driver" information
    Then user should be able to login

  Scenario: Login as a sales manager
    When user enters "sales manager" information
    Then user should be able to login

  Scenario: Login as a store manager
    When user enters "store manager" information
    Then user should be able to login
