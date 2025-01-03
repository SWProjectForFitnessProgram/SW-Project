Feature: User Management
  As an Admin, I want to manage instructor and client accounts, approve new accounts, update information, deactivate accounts when necessary, and monitor user activity and engagement statistics.

  #1 : Approve New Accounts
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
#2
  Scenario: No pending instructor accounts
    Given I am logged in as an admin
    And there are no pending instructor accounts
    When I click on "Approve Instructors" page
    Then I should see a message "No pending instructor accounts"
#3
  Scenario: View pending client accounts
    Given I am logged in as an admin
    And there are pending Client accounts:
      | Email             | Password      |
      | client1@test.com | clientOne |
      | client2@test.com | clientTwo |
    When I click on "Approve Client" page
    Then I should see a list of pending Client accounts:
      | Email             | Password      |
      | instructor1@test.com | InstructorOne |
      | instructor2@test.com | InstructorTwo |
#4
  Scenario: No pending client accounts
    Given I am logged in as an admin
    And there are no pending client accounts
    When I click on "Approve Client" page
    Then I should see a message "No pending client accounts"

  #5 Update Accounts
  Scenario: Update instructor account information
    Given I am logged in as an admin
    And the following instructor exists:
      | Email             | Password      | Name          |
      | instructor1@test.com | InstructorOne | John Doe      |
    When I update the instructor account with:
      | Email             | Password      | Name            |
      | instructor1@test.com | UpdatedPass  | John Smith      |
    Then the instructor account should be updated with:
      | Email             | Password      | Name            |
      | instructor1@test.com | UpdatedPass  | John Smith      |
  #6
  Scenario: Update client account information
    Given I am logged in as an admin
    And the following client exists:
      | Email             | Password      | Name       |
      | client1@test.com     | ClientOne    | Jane Doe   |
    When I update the client account with:
      | Email             | Password      | Name         |
      | client1@test.com     | NewClientPass | Jane Smith  |
    Then the client account should be updated with:
      | Email             | Password      | Name         |
      | client1@test.com     | NewClientPass | Jane Smith  |

  #7 Deactivate Accounts
  Scenario: Deactivate an instructor account
    Given I am logged in as an admin
    And the following instructor exists:
      | Email             | Password      | Active |
      | instructor1@test.com | InstructorOne | true   |
    When I deactivate the instructor account with email "instructor1@test.com"
    Then the instructor account should be marked as deactivated:
      | Email             | Active |
      | instructor1@test.com | false |
  #8
  Scenario: Deactivate a client account
    Given I am logged in as an admin
    And the following client exists:
      | Email             | Password   | Active |
      | client1@test.com     | ClientOne | true   |
    When I deactivate the client account with email "client1@test.com"
    Then the client account should be marked as deactivated:
      | Email             | Active |
      | client1@test.com     | false |

  #9 Monitor User Activity and Engagement Statistics
  Scenario: View user activity and engagement statistics
    Given the admin has selected the "monitor user activity" option
    When the admin views activity reports
    Then the system should display statistics including:
      | Metric             | Description                        |
      | Total Active Users | 20                                 |
      | Total Inactive Users |10                                |
      | User Engagement Rate | 50%                              |
#  #10
#  Scenario: View engagement statistics for instructors
#    Given the admin has selected the "monitor instructor activity" option
#    When the admin views the instructor engagement report
#    Then the system should display statistics including:
#      | Metric                 | Description                          |
#      | Total Classes Conducted | Number of classes taught by instructors |
#      | Total Articles Shared  | Number of articles shared by instructors |
#      | Instructor Engagement  | Level of instructor activity         |
#  #11
#  Scenario: View engagement statistics for clients
#    Given the admin has selected the "monitor client activity" option
#    When the admin views the client engagement report
#    Then the system should display statistics including:
#      | Metric               | Description                               |
#      | Total Programs Enrolled | Number of programs clients enrolled in |
#      | Completed Programs   | Programs completed by clients           |
#      | Client Engagement Rate | Level of client activity and interaction |
