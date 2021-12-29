@login @smoke
Feature: Users should be able to login

  Background:
    Given the user is on the login page

  @driver @vyt-123
  Scenario: Login as a driver
    When the user enters the driver information
    Then the user should be able to login

    @sales_manager
    Scenario: Login as sales manager
      When the user enters the sales manager information
      Then the user should be able to login

      @store_manager @vyt-123
      Scenario: Login as store manager
        When the user enters the store manager information
        Then the user should be able to login