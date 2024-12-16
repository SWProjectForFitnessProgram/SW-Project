Feature: Progress Tracking
  As a registered user
  I want to track my personal fitness milestones and view my achievements or badges
  So that I can monitor my progress and stay motivated in my fitness journey

  Scenario: Track fitness milestones
    Given I am logged in and on the "Progress Tracking" page
    When I input my personal fitness data (weight, BMI, attendance)
    Then I should see my current fitness milestones updated (weight, BMI, attendance records)

  Scenario: View achievements and badges
    Given I have completed a fitness program
    When I view my progress
    Then I should see any achievements or badges earned for completing the program
      | Achievement         | Badge                          |
      | Completed 8-week program | Fitness Achiever Badge |
      | BMI improvement  | Health Champion Badge       |

  Scenario: Track progress over time
    Given I have entered my fitness milestones (weight, BMI, attendance) at different times
    When I check my progress history
    Then I should see a record of my previous fitness milestones, with clear indications of improvement or decline over time
      | Date       | Weight  | BMI   | Attendance |
      | 2024-10-01 | 70kg  | 24.5  | 80%        |
      | 2024-11-01 | 68kg  | 23.9  | 85%        |

  Scenario: View overall fitness progress summary
    Given I have completed multiple programs and entered various fitness milestones
    When I check my overall progress summary
    Then I should see an overview of my fitness journey, including the total number of completed programs, achievements earned, and the change in my fitness milestones
      | Metric              | Value              |
      | Total Programs      | 3                  |
      | Achievements Earned | 5                  |
      | Weight Lost         | 3kg               |
      | BMI Reduction       | 0.6                |
