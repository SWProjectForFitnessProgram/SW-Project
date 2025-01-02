Feature: Notifications and Updates

  Background: Setup Instructor and Clients
    Given the instructor is logged in
    And the instructor has an active program "Fitness Program" with enrolled clients "Alice", "Bob", and "Charlie"

  Scenario: Notify clients about a program schedule change
    When the instructor changes the "Fitness Program" schedule from "Mondays and Wednesdays at 7 PM" to "Tuesdays and Thursdays at 6 PM"
    Then "Alice" should receive a notification: "The schedule for Fitness Program has been changed to Tuesdays and Thursdays at 6 PM."
    And "Bob" should receive a notification: "The schedule for Fitness Program has been changed to Tuesdays and Thursdays at 6 PM."
    And "Charlie" should receive a notification: "The schedule for Fitness Program has been changed to Tuesdays and Thursdays at 6 PM."

  Scenario: Notify clients about a cancelled session
    When the instructor cancels the "Fitness Program" session on "October 26, 2024"
    Then "Alice" should receive a notification: "The Fitness Program session on October 26, 2024 has been cancelled."
    And "Bob" should receive a notification: "The Fitness Program session on October 26, 2024 has been cancelled."
    And "Charlie" should receive a notification: "The Fitness Program session on October 26, 2024 has been cancelled."

  Scenario: Announce a new program
    When the instructor announces a new program "Advanced Yoga Flow" starting on "November 15, 2024"
    Then "Alice" should receive a notification: "A new program, Advanced Yoga Flow, is starting on November 15, 2024. Check it out!"
    And "Bob" should receive a notification: "A new program, Advanced Yoga Flow, is starting on November 15, 2024. Check it out!"
    And "Charlie" should receive a notification: "A new program, Advanced Yoga Flow, is starting on November 15, 2024. Check it out!"

  Scenario: Announce a special offer
    When the instructor announces a special offer: "20% off all personal training sessions for the month of December"
    Then "Alice" should receive a notification: "Special Offer: 20% off all personal training sessions for the month of December!"
    And "Bob" should receive a notification: "Special Offer: 20% off all personal training sessions for the month of December!"
    And "Charlie" should receive a notification: "Special Offer: 20% off all personal training sessions for the month of December!"

  Scenario: Announce a special offer to only specific clients
    Given the instructor has a list of clients who are eligible for the offer
    And the clients "Alice" and "Bob" are in the list
    When the instructor announces a special offer: "20% off all personal training sessions for the month of December" to the eligible clients
    Then "Alice" should receive a notification: "Special Offer: 20% off all personal training sessions for the month of December!"
    And "Bob" should receive a notification: "Special Offer: 20% off all personal training sessions for the month of December!"
    And "Charlie" should not receive a notification