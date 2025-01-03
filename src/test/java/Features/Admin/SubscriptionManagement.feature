Feature: Subscription Management
  As an Admin
  I want to manage subscription plans for clients and instructors
  So that I can offer various subscription levels (e.g., Basic, Premium).

  Scenario: Assign a Basic subscription to a client
    Given the client "Mohammed" is registered with email "Mo@gmail.com" and password "123456"
    When I assign the "Basic" subscription plan to "Mohammed"
    Then "Mohammed's" subscription plan should be "Basic"

  Scenario: Assign a Premium subscription to an instructor
    Given the instructor "Dina" is registered with email "Dina@gmail.com" and password "423536"
    When I assign the "Premium" subscription plan to "Dina"
    Then "Dina's" subscription plan should be "Premium"

  Scenario: Change a client's subscription from Basic to Premium
    Given the client "Ali" has a "Basic" subscription And He registered with email "Ali@gmail.com" and password "423536"
    When I change "Ali"'s subscription to "Premium"
    Then "Ali"'s subscription plan should be "Premium"

  Scenario: View all available subscription plans
    Given I am logged in as an admin
    When I view the available subscription plans
    Then I should see "Basic" and "Premium" plans listed
