Feature: Program Monitoring

  As an admin,
  I want to monitor program statistics,
  So that I can track performance and generate insights.

  Scenario: View statistics on the most popular programs by enrollment
    Given the admin is logged in
    When the admin requests statistics on program enrollments
    Then the system displays the top 5 programs by enrollment
      | Program Name | Enrollment Count   |
      | Program B    | 5              |
      | Program A    | 4              |
      | Program C    | 3              |
      | Program E    | 2              |
      | Program D    | 1              |

  Scenario: Generate a revenue report
    Given the admin is logged in
    When the admin generates a revenue report for the last quarter
    Then the system generates and displays the revenue report
      | Program Name | Revenue |
      | Program A    | 140.0            |
      | Program B    | 150.0            |
      | Program C    | 90.0             |
      | Program D    | 70.0             |
      | Program E    | 160.0             |
  Scenario: Track active and completed programs
    Given the admin is logged in
    When the admin views program statuses
    Then the system displays a list of active and completed programs
      | Program Name | Status |
      | Program A    | Completed |
      | Program B    | Completed |
      | Program C    | Completed |
      | Program D    | Upcoming |
      | Program E    | Completed |



