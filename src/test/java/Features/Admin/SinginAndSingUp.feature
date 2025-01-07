Feature: User Sign-Up and Sign-In Process
#1
  Scenario: Sign up for instructor successfully
    Given  "instructor" provides the following details:
      | Name       | John Doe       |
      | Email      | ibiahygh.g@gmail.com |
      | Age        | 30            |
      | Password   | password123   |
    When the "instructor" attempts to sign up
    Then Sign up operation should succeed
    And the "instructor" should see "The Admin will approve your account as soon as possible."
    And the "instructor" should receive an email notification upon approval
#2
  Scenario: Sign up for client successfully
    Given  "client" provides the following details:
      | Name       | Jane Smith    |
      | Email      | talaalhendiuni4@gmail.com |
      | Age        | 25            |
      | Password   | clientpass123 |
    When the "client" attempts to sign up
    Then Sign up operation should succeed
    And the "client" should see "The Admin will approve your account as soon as possible."
    And the "client" should receive an email notification upon approval
#3
  Scenario: Sign up unsuccessfully
    Given "instructor" provides the following details:
      | Name       | Invalid User  |
      | Email      | invalid.email |
      | Age        | 17            |
      | Password   | short         |
    When the "instructor" attempts to sign up
    Then the operation should fail
    And the user should see "The operation is not allowed: Invalid email, age must be 18 or older or password must be at least 8 characters."

  Scenario: Sign in successfully
    Given the following accounts exist:
      | Role       | Email             | Password      |
      | Instructor | john.doe@gmail.com | password123   |
      | Client     | jane.smith@gmail.com | clientpass123 |
      | Admin      | g.safw2018@gmail.com  | 123456  |
    When the user attempts to sign in
    Then Sign in operation should succeed
    And the user should see "Sign in successful."


  Scenario: Sign in with unfounded account
    Given the following accounts exist:
      | Role       | Email             | Password      |
      | Instructor | john@gmail.com | password123   |
      | Client     | janeith@gmail.com | clientpass123 |
      | Admin      | admin@gmail.com  | adminpass123  |
    When the user attempts to sign in
    Then Sign in operation should fail
    And the user should see "Account not found."
