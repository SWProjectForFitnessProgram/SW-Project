Feature: Program Exploration and Enrollment
  As a registered user
  I want to browse programs using filters and enroll in programs
  So that I can choose the most suitable fitness program for my goals


  Scenario: Filter programs by difficulty level
    Given I navigate to the "Programs" section
    When I filter programs by difficulty level "Beginner"
    Then I should see a list of programs with difficulty level "Beginner"

  Scenario: Filter programs by focus area
    Given I navigate to the "Programs" section
    When I filter programs by focus area "Weight Loss"
    Then I should see a list of programs focused on "Weight Loss"

  Scenario: Enroll in a program
    Given I navigate to the "Programs" section
    And I select a program named "Beginner Weight Loss Plan"
    When I click on "Enroll"
    Then I should see a confirmation message "You have successfully enrolled"
    And I should see the schedule for the program "Beginner Weight Loss Plan"

  Scenario: View program details
    Given I navigate to the "Programs" section
    And I select a program named "Advanced Muscle Building Plan"
    When I click on "View Details"
    Then I should see the following program details:
      | Field         | Value                      |
      | Name          | Advanced Muscle Building Plan |
      | Difficulty    | Advanced                  |
      | Focus Area    | Muscle Building           |
      | Duration      | 12 Weeks                  |
      | Schedule      | Monday, Wednesday, Friday |