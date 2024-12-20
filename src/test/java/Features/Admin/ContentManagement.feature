Feature: Content Management
  As an Admin
  I want to approve or reject wellness articles, tips, and recipes shared by instructors
  So that I can manage content on the platform effectively.

  Scenario: Approve a wellness article
    Given the wellness article "Healthy Eating Tips" is pending approval
    When I approve the article
    Then the article status should be "Approved"

  Scenario: Reject a wellness article
    Given the wellness article "Healthy Eating Tips" is pending approval
    When I reject the article
    Then the article status should be "Rejected"

  Scenario: Handle user feedback and complaints
    Given the user has submitted a complaint about "Program A"
    When I review the complaint
    Then I should be able to mark the complaint as "Resolved"

  Scenario: Approve a health tip shared by an instructor
    Given the health tip "Staying Hydrated" is pending approval
    When I approve the tip
    Then the tip status should be "Approved"

  Scenario: Reject a recipe shared by an instructor
    Given the recipe "Vegan Pasta" is pending approval
    When I reject the recipe
    Then the recipe status should be "Rejected"
