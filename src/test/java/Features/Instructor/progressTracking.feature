Feature:  Progress Tracking
Instructors should be able to monitor client progress and send motivational reminders or recommendations.

  Background: Setup Instructor and Program
    Given the instructor is logged in
    And the instructor has an active program "Fitness Program" with enrolled clients

  Scenario: Instructor views a client's completion rate
    Given "Alice" has completed 7 out of 10 workouts in "Fitness Program"
    When the instructor views "Alice"'s progress report
    Then the instructor should see "Alice"'s completion rate as 70.0%

  Scenario: Instructor views a client's attendance
    Given "Bob" has attended 8 out of 12 sessions of "Fitness Program"
    When the instructor views "Bob"'s progress report
    Then the instructor should see "Bob"'s attendance as 66.67 %

  Scenario: Instructor sends a motivational reminder for low completion rate
    Given "Charlie" has completed 3 out of 10 workouts in "Fitness Program"
    When the instructor sends a motivational reminder to "Charlie"
    Then "Charlie" should receive the message "Keep pushing, Charlie! You've got this!"
