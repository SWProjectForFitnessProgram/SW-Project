Feature: Account Management

  Background: User Logs In
    Given the user logs in with valid "validId" and "validPassword"


  Scenario: Create Profile
    Given I am logged in
    When I navigate to Create Profile
    And I enter my personal details depends on 1 and "Taqwa Odeh"
    And I enter my age depends on 2 and "21"
    And I set my fitness goal depends on 3 and "Weight Loss"
    And I specify my dietary preferences depends on 4 and "Vegan"
    And I add dietary restrictions depends on 5 and "Gluten-Free"
    Then my profile should be created successfully

  Scenario: Customize Profile
    Given I am logged in
    When I navigate to My Profile
    And I update my fitness goal depends on 1 and "Muscle Building"
    And I update my dietary preferences depends on 2 and "Vegetarian"
    And I update my dietary restrictions depends on 3 and "Lactose-Free"
    Then my profile should be customized successfully


  Scenario: View Profile
    Given I am logged in
    When I navigate to My Profile
    Then I should see my personal details including:
      | Field              | Value           |
      | Name               | Taqwa Odeh     |
      | Age                | 21              |
      | Fitness Goal       | Weight Loss     |
      | Dietary Preferences| Vegan           |
      | Dietary Restrictions| Gluten-Free     |
