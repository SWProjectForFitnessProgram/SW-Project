Feature: Instructor Schedule Management and Notifications

  Scenario: Instructor changes the schedule for a program
    Given the instructor has an active program "Fitness Program" with enrolled clients "Alice", "Bob", and "Charlie"
    And the program "Fitness Program" has the following schedule:
      | days                       | time    | scheduleType |
      | Monday, Wednesday, Friday   | 10:00 AM| In-person    |
    When the instructor changes the "Fitness Program" schedule from "Monday, Wednesday, Friday at 10:00 AM" to "Tuesday, Thursday at 8:00 AM"
    Then "Alice" should receive a notification: "The schedule for Fitness Program has been changed to Tuesday, Thursday at 8:00 AM."
    And "Bob" should receive a notification: "The schedule for Fitness Program has been changed to Tuesday, Thursday at 8:00 AM."
    And "Charlie" should receive a notification: "The schedule for Fitness Program has been changed to Tuesday, Thursday at 8:00 AM."

  Scenario: Instructor cancels a session
    Given the instructor has an active program "Fitness Program" with enrolled clients "Alice", "Bob", and "Charlie"
    And the program "Fitness Program" has the following schedule:
      | days                       | time    | scheduleType |
      | Monday, Wednesday, Friday   | 10:00 AM| In-person    |
    When the instructor cancels the "Fitness Program" session on "Monday, 10:00 AM"
    Then "Alice" should receive a notification: "The Fitness Program session on Monday, 10:00 AM has been cancelled."
    And "Bob" should receive a notification: "The Fitness Program session on Monday, 10:00 AM has been cancelled."
    And "Charlie" should receive a notification: "The Fitness Program session on Monday, 10:00 AM has been cancelled."

  Scenario: Instructor announces a new program
    Given the instructor has an active program "Fitness Program" with enrolled clients "Alice", "Bob", and "Charlie"
    When the instructor announces a new program "Advanced Fitness Program" starting on "January 15th"
    Then "Alice" should receive a notification: "A new program, Advanced Fitness Program, is starting on January 15th. Check it out!"
    And "Bob" should receive a notification: "A new program, Advanced Fitness Program, is starting on January 15th. Check it out!"
    And "Charlie" should receive a notification: "A new program, Advanced Fitness Program, is starting on January 15th. Check it out!"
