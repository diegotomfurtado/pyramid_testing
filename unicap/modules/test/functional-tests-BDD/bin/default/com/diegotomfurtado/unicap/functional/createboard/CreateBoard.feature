@TestRun
Feature: Create Board on Trello
  Any user, who has a valid account, should create a new board on Trello application.

  Background:
    Given a user is logged in on Trello Web Application

  Scenario: Validate if a user could create a new board.
    When a user follows the steps to create a new board
    Then a user will see a new board created 
