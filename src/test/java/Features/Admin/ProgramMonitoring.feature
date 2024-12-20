Feature: Program Monitoring

  Scenario: View most popular programs
    Given the admin has selected the "program monitoring" option
    When the admin views most popular programs
    Then the system should display a list of programs ordered by enrollment

  Scenario: View program reports
    Given the admin has selected the "program monitoring" option
    When the admin views program reports
    Then the system should display the following reports:
      | Report Name | Description |
      | Revenue | Total revenue generated from program sales |
      | Attendance | Average attendance per program |
      | Client Progress | Percentage of clients completing programs |

  Scenario: View active and completed programs
    Given the admin has selected the "program monitoring" option
    When the admin views active and completed programs
    Then the system should display the following programs:
      | Program Status | Program List |
      | Active | [List of active program names] |
      | Completed | [List of completed program names] |