Feature: client Interaction
  Scenario: Sending a Personalized Message
    Given the instructor is logged in
    And the instructor has an active program "Fitness Program" with enrolled clients
    When the instructor selects a client "tala" and sends a personalized message "You are doing a great job!"
    Then the client should receive the personalized message

  Scenario: Posting a Forum Message
    Given the instructor is logged in
    And the instructor has an active program "Fitness Program" with a discussion forum
    When the instructor posts a message to the forum
    Then all enrolled clients should see the message on the forum

  Scenario: Providing Feedback to a Client
    Given the instructor is logged in
    And the instructor has access to a client's progress report for "Alice"
    When the instructor provides feedback to the client
    Then the client should receive the feedback