Feature: Feedback and Reviews
  As a registered user
  I want to provide feedback and suggestions for completed programs
  So that I can help improve the quality of the programs and share my experience with others

  Scenario: Rate a completed program
    Given I have completed a fitness program named "Beginner Weight Loss Plan"
    When I rate the program with a score of 4 out of 5
    Then the program should display an updated average rating


  Scenario: Write a review for a completed program
    Given I have completed a fitness program named "Advanced Muscle Building Plan"
    When I submit a review saying "This program really helped me build strength!"
    Then the review should be visible under the program's details section

  Scenario: Submit an improvement suggestion to an instructor
    Given I have completed a fitness program named "Yoga for Beginners"
    When I submit a suggestion saying "Include more advanced poses for progression."
    Then  Your suggestion has been sent to the instructor
