Feature: User Management
  As an Admin, I want to manage instructor and client accounts, approve new accounts, update information, deactivate accounts when necessary, and monitor user activity and engagement statistics.

#  Approve New Accounts
  Scenario: Approve adding instructor successfully
    Given the admin has selected the "new instructor request" option
    When the admin chooses an account to approve
    Then the system should send a message to the instructor informing them that the account has been approved successfully

  Scenario: Error approving instructor account
    Given the admin has selected the "new instructor request" option
    When the admin enters a non-valid account ID
    Then the system should display a message informing the admin that the ID entered is not valid

  Scenario: Approve adding client successfully
    Given the admin has selected the "new client request" option
    When the admin enters a valid account ID
    Then the system should send a message to the client informing them that the account has been approved successfully

  Scenario: Error approving client account
    Given the admin has selected the "new client request" option
    When the admin enters a non-valid account ID
    Then the system should display a message informing the admin that the ID entered is not valid

#  Update Account Information
  Scenario: Approve update of instructor information successfully
    Given the admin has selected the "update instructor request" option
    When the admin enters a valid account ID
    And the updated data is valid
    Then the system should update the instructor's information successfully

  Scenario: Error updating instructor information with invalid ID
    Given the admin has selected the "update instructor request" option
    When the admin enters a non-valid account ID
    Then the system should display a message informing the admin that the ID entered is not valid

  Scenario: Error updating instructor information with invalid data
    Given the admin has selected the "update instructor request" option
    When the admin enters a valid account ID
    And the updated data is invalid
    Then the system should display a message informing the admin that the update operation was rejected

  Scenario: Approve update of client information successfully
    Given the admin has selected the "update client request" option
    When the admin enters a valid account ID
    And the updated data is valid
    Then the system should update the client's information successfully

  Scenario: Error updating client information with invalid ID
    Given the admin has selected the "update client request" option
    When the admin enters a non-valid account ID
    Then the system should display a message informing the admin that the ID entered is not valid

  Scenario: Error updating client information with invalid data
    Given the admin has selected the "update client request" option
    When the admin enters a valid account ID
    And the updated data is invalid
    Then the system should display a message informing the admin that the update operation was rejected

#  Deactivate Accounts
  Scenario: Deactivate instructor account successfully
    Given the admin has selected the "deactivate instructor account" option
    When the admin chooses a valid account ID
    Then the system should remove the instructor account from the database

  Scenario: Error deactivating instructor account
    Given the admin has selected the "deactivate instructor account" option
    When the admin chooses an invalid account ID
    Then the system should display a message informing the admin that the ID entered is invalid

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

