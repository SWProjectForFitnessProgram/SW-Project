Feature:  Progress Tracking
Instructors should be able to monitor client progress and send motivational reminders or recommendations.

  Background: Setup Instructor and Program
    Given the instructor is logged in
    And the instructor has an active program "Fitness Program" with enrolled clients

  Scenario: Instructor views a client's completion rate
    Given "Alice" has completed 7 out of 10 workouts in "Fitness Program"
    When the instructor views "Alice"'s progress report
    Then the instructor should see "Alice"'s completion rate as 70%

  Scenario: Instructor views a client's attendance
    Given "Bob" has attended 8 out of 12 sessions of "Fitness Program"
    When the instructor views "Bob"'s progress report
    Then the instructor should see "Bob"'s attendance as 66.67 %

  Scenario: Instructor sends a motivational reminder for low completion rate
    Given "Charlie" has completed 3 out of 10 workouts in "Fitness Program"
    When the instructor sends a motivational reminder to "Charlie"
    Then "Charlie" should receive the message "Keep pushing, Charlie! You've got this!"

#  Scenario: Instructor sends a recommendation for improving attendance
#    Given "David" has attended only 2 out of 8 sessions of "Fitness Program"
#    When the instructor sends a recommendation to "David"
#    Then "David" should receive the message "Consistent attendance is key for seeing results. Try to schedule your workouts in advance!"
#
#  Scenario: Instructor views progress of a client not in their program (Negative Test)
#    Given "Eve" is not enrolled in "Fitness Program"
#    When the instructor tries to view "Eve"'s progress report
#    Then an error message should be displayed: "Client Eve is not enrolled in this program."
#
#  Scenario: Instructor views progress when no progress is recorded
#    Given "Frank" has no recorded progress in "Fitness Program"
#    When the instructor views "Frank"'s progress report
#    Then a message should be displayed "No progress recorded for Frank yet."