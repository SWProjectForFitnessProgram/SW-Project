Feature: Notifications and Updates
  As an instructor,
  I want to notify clients about schedule changes and new programs or special offers,
  So that they are informed and engaged with my fitness services.

  Background:
    Given the instructor is logged in

  Scenario: Notify clients about changes to program schedules
    Given the instructor has an existing program "Fitness Program" schedule
    When the instructor updates the program schedule with the following details:
      | Days             | Time       | Schedule Type |
      | Tuesday, Thursday | 11:00 AM  | Online         |
    Then notifications about the updated schedule should be sent to all enrolled clients

  Scenario: Announce a new fitness program
    When the instructor creates a new program with the following details:
      | Program Title | Duration | Difficulty Level | Goals          | Price |
      | Bootcamp 2025 | 6 Weeks  | Intermediate     | Weight Loss    | Free  |
    And the program includes schedules with the following details:
      | Days             | Time       | Schedule Type |
      | Monday, Wednesday | 10:00 AM  | In Person      |
    Then notifications about the new program should be sent to all registered clients

  Scenario: Announce a special offer
    When the instructor creates a special offer "Discount 50%" for an existing program "Fitness Program"
    Then notifications about the special offer should be sent to all registered clients
