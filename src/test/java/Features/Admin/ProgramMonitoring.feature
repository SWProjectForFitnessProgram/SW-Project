Feature: Program Monitoring

  As an admin,
  I want to monitor program statistics,
  So that I can track performance and generate insights.

  Scenario: View statistics on the most popular programs by enrollment
    Given the admin is logged in
    When the admin requests statistics on program enrollments
    Then the system displays the top 5 programs by enrollment
      | Program Name | Enrollment Count |
      | Program A    | 200              |
      | Program B    | 180              |
      | Program C    | 150              |
      | Program D    | 120              |
      | Program E    | 100              |

  Scenario: Generate a revenue report
    Given the admin is logged in
    When the admin generates a revenue report for the last quarter
    Then the system generates and displays the revenue report
      | Program Name | Revenue Generated ($) |
      | Program A    | 5000                  |
      | Program B    | 7500                  |
      | Program C    | 6200                  |

  Scenario: Track active and completed programs
    Given the admin is logged in
    When the admin views program statuses
    Then the system displays a list of active and completed programs
      | Program Name | Status |
      | Program A    | Active |
      | Program B    | Active |
      | Program C    | Completed |
      | Program D    | Completed |
      | Program E    | Completed |
