Feature: client Interaction
  Scenario: Sending a Personalized Message
    Given an instructor is logged in
    And the instructor has an active program with enrolled clients
    When the instructor selects a client and sends a personalized message
    Then the client should receive the personalized message

#  Scenario: Posting a Forum Message
#    Given an instructor is logged in
#    And the instructor has an active program with a discussion forum
#    When the instructor posts a message to the forum
#    Then all enrolled clients should see the message on the forum
#
#  Scenario: Providing Feedback to a Client
#    Given an instructor is logged in
#    And the instructor has access to a client's progress report
#    When the instructor provides feedback to the client
#    Then the client should receive the feedback