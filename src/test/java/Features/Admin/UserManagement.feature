Feature: User Management
  As an Admin, I want to manage instructor and client accounts, approve new accounts, update information, deactivate accounts when necessary, and monitor user activity and engagement statistics.

#  Approve New Accounts
  Scenario: View pending instructor accounts
    Given I am logged in as an admin
    And there are pending instructor accounts:
      | Email             | Password      |
      | instructor1@test.com | InstructorOne |
      | instructor2@test.com | InstructorTwo |
    When I click on "Approve Instructors" page
    Then I should see a list of pending instructor accounts:
      | Email             | Password      |
      | instructor1@test.com | InstructorOne |
      | instructor2@test.com | InstructorTwo |

  Scenario: No pending instructor accounts
    Given I am logged in as an admin
    And there are no pending instructor accounts
    When I click on "Approve Instructors" page
    Then I should see a message "No pending instructor accounts"


  Scenario: View a queue of pending client accounts
    Given I am logged in as an admin
    When the admin chooses "Approve Clients"
    Then a queue of client accounts that signed up and need approval should be displayed

#  Monitor User Activity and Engagement Statistics
  Scenario: View user activity and engagement statistics
    Given the admin has selected the "monitor user activity" option
    When the admin views activity reports
    Then the system should display statistics including:
      | Metric | Description |
      | Total Active Users | Number of users currently active |
      | Total Inactive Users | Number of users not active |
      | User Engagement Rate | Average user interactions |

  Scenario: View engagement statistics for instructors
    Given the admin has selected the "monitor instructor activity" option
    When the admin views the instructor engagement report
    Then the system should display statistics including:
      | Metric | Description |
      | Total Classes Conducted | Number of classes taught by instructors |
      | Total Articles Shared | Number of articles shared by instructors|
      | Instructor Engagement | Level of instructor activity |

  Scenario: View engagement statistics for clients
    Given the admin has selected the "monitor client activity" option
    When the admin views the client engagement report
    Then the system should display statistics including:
      | Metric | Description |
      | Total Programs Enrolled | Number of programs clients enrolled in |
      | Completed Programs | Programs completed by clients |
      | Client Engagement Rate | Level of client activity and interaction|
#
