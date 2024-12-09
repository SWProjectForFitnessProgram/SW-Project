Feature: Add Accounts
  As an Admin, I want to add accounts for instructors and clients efficiently, ensuring the process is fast, user-friendly, and accurate.

  Scenario: add Instructor successfully
    Given the admin has selected the "Add Instructor" option
    When the instructor's name, age, specialization, email, and password are provided correctly
    Then the system should display a message indicating that the instructor has been added successfully


  Scenario:Add Instructor with Missing Information
    Given the admin has selected the "Add Instructor" option
    When one or more fields (name, age, specialization, email, or password) are left empty
    Then the system should display an error message indicating that the addition process has been rejected due to missing information


  Scenario: Add Client successfully
    Given the admin has selected the "Add Client" option
    When the client's name, age, email, and password are provided correctly
    Then the system should display a message indicating that the client has been added successfully


  Scenario: Add Client with Missing Information
    Given the admin has selected the "Add Client" option
    When one or more fields (name, age, email, or password) are left empty
    Then the system should display an error message indicating that the addition process has been rejected due to missing information
