Feature: Sign Up and Sign In
  As a user (instructor, client, or admin),
  I want to sign up for an account and sign in after approval
  So that I can access the system based on my role.

  # Sign Up Scenarios
  Scenario: Successful instructor sign up
    Given no account exists with email "instructor1@test.com"
    When the instructor signs up with:
      | Email             | Password      | Name       |
      | instructor1@test.com | InstructorOne | John Doe   |
    Then the account should be created as pending approval with:
      | Email             | Password      | Name       | Status  |
      | instructor1@test.com | InstructorOne | John Doe   | Pending |
    And the system should display the message "Your account is pending admin approval."

  Scenario: Admin approves an instructor account
    Given a pending instructor account exists with email "instructor1@test.com"
    When the admin approves the account for email "instructor1@test.com"
    Then the account status should be updated to "Approved"
    And the instructor should receive an email saying "Your account has been approved."

  Scenario: Instructor sign up with an existing email
    Given an account exists with email "instructor1@test.com"
    When the instructor signs up with:
      | Email             | Password      | Name       |
      | instructor1@test.com | InstructorOne | John Doe   |
    Then the system should display an error message "Email already exists."

  # Sign In Scenarios
  Scenario: Successful sign in as an instructor
    Given an approved instructor account exists with email "instructor1@test.com" and password "InstructorOne"
    When the instructor signs in with:
      | Email             | Password      |
      | instructor1@test.com | InstructorOne |
    Then the instructor should be signed in successfully.

  Scenario: Failed sign in with incorrect credentials
    Given an approved client account exists with email "client1@test.com" and password "ClientOne"
    When the client signs in with:
      | Email             | Password      |
      | client1@test.com     | WrongPassword |
    Then the system should display an error message "Invalid credentials."

  Scenario: Admin sign in
    Given an admin account exists with email "admin@test.com" and password "AdminPass"
    When the admin signs in with:
      | Email             | Password  |
      | admin@test.com       | AdminPass |
    Then the admin should be signed in successfully.
