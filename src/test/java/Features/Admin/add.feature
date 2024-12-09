Feature: Add
  as an Admin I want to be able to add accounts of instructors and clients as well, I want the process to be fast , easy and accurate.

  Scenario: add Instructor successfully
    Given the admin has chosen add instructon option
    When instructor name , age , specialization, email and password entered correctly
    Then the admin will get a message tells that addition process is competed successfully

  Scenario: add Instructor but not all information was filled in.
    Given the admin has chosen add instructon option
    When instructor name or age or specialization or email or password was empty
    Then  the admin will get a message tells that addition process is rejected

  Scenario: add Client successfully
    Given the admin has chosen add client option
    When client name , age , email and password entered correctly
    Then the admin will get a message tells that addition process is competed successfully

  Scenario: add Client but not all information was filled in.
    Given the admin has chosen add client option
    When client name or age or email or password was empty
    Then  the admin will get a message tells that addition process is rejected