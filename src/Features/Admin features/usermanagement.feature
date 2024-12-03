Feature: User Management
  As an admin
  I want to manage users
  So that I can control access to the system

  Scenario: Add a new user
    Given the admin is logged into the system
    When the admin adds a new user with the name "anything"
    Then the user "anything" should be successfully added to the system

  Scenario: Deactivate a user
    Given the admin is logged into the system
    And a user with the name "anything" exists
    When the admin deactivates the user "anything"
    Then the user "anything" should be deactivated

Scenario: Update a user's information
  Given the admin is logged into the system
  And a user with the name "anything" exists
  When the admin updates the user's email to "john.updated@example.com"
  Then the user's email should be updated successfully

Scenario: Approve a new instructor registration
  Given the admin is logged into the system
  And a new instructor with the name "Jane Smith" has requested registration
  When the admin approves the registration
  Then the instructor "Jane Smith" should be approved successfully

Scenario: Monitor user activity and engagement statistics
  Given the admin is logged into the system
  When the admin views the user activity and engagement statistics
  Then a report showing activity and engagement should be displayed
