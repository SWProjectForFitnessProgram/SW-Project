Feature: Subscription Management
  As an Admin
  I want to manage subscription plans for clients and instructors
  So that I can offer various subscription levels (e.g., Basic, Premium).

  Scenario: Assign a Basic subscription to a client
    Given the client "Alice" is registered
    When I assign the "Basic" subscription plan to Alice
    Then Alice's subscription plan should be "Basic"

  Scenario: Assign a Premium subscription to an instructor
    Given the instructor "Bob" is registered
    When I assign the "Premium" subscription plan to Bob
    Then Bob's subscription plan should be "Premium"

  Scenario: Change a client's subscription from Basic to Premium
    Given the client "Charlie" has a "Basic" subscription
    When I change Charlie's subscription to "Premium"
    Then Charlie's subscription plan should be "Premium"

  Scenario: View all available subscription plans
    Given I am logged in as an admin
    When I view the available subscription plans
    Then I should see "Basic" and "Premium" plans listed
