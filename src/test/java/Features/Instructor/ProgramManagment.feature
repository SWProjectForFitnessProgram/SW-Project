Feature: Program Management
  Background:
    Given the instructor is logged in

  Scenario: Create a fitness program
    When the following details are provided
      | Program title    | Get Fit & Moving Challenge       |
      | Duration         | 30 days                          |
      | Difficulty level | Beginners                        |
      | Goals            | Weight Loss, Full Body           |
      | Video Tutorials  | https://youtu.be/f3zOrYCwquE     |
      | Images           | https://unsplash.com/s/photos/gym   |
      | Documentation    | https://www.everydayhealth.com/fitness/guide/     |
      | Price            | 29.99 $                          |
      | Schedule Type    | Online                           |
      | Days             | Monday,Wednesday,Friday        |
      | Time             | 5:00 PM - 7:00 PM                |

    Then the program is created with the specified details "Get Fit & Moving Challenge"

  Scenario: Update a fitness program Successfully
    Given a fitness program with the title "Get Fit & Moving Challenge" exists
    When the instructor updates the program with the following details
      | Program title    | Get Fit & Moving Challenge Updated |
      | Duration         | 3 months                          |
      | Difficulty level | Intermediate                      |
      | Goals            | Weight Loss, Toning               |
      | Video Tutorials  | https://youtu.be/newVideo         |
      | Images           | https://example.com/images/newFit |
      | Documentation    | https://example.com/docs/newFit   |
      | Price            | 49.99 $                           |
      | Schedule Type    | In-Person                         |
      | Days             | Tuesday, Thursday                 |
      | Time             | 6:00 PM - 8:00 PM                 |
    Then the program is updated successfully with the new details


  Scenario: Update a non-existing fitness program
    Given a fitness program with the title "Get Fit" doesn't exist
    When the instructor updates the program with the following details
      | Program title    | Get Fit & Moving Challenge Updated |
      | Duration         | 3 months                          |
      | Difficulty level | Intermediate                      |
      | Goals            | Weight Loss, Toning               |
      | Video Tutorials  | https://youtu.be/newVideo         |
      | Images           | https://example.com/images/newFit |
      | Documentation    | https://example.com/docs/newFit   |
      | Price            | 49.99 $                           |
      | Schedule Type    | In-Person                        |
      | Days             | Tuesday, Thursday                 |
      | Time             | 6:00 PM - 8:00 PM                |
    Then the system displays an error message indicating that the program does not exist

  Scenario Outline: Delete a fitness program (Success and Failure)
    When the instructor attempts to delete the program with title "<program_title>"
    Then the program deletion result is:
      | Status       | Message                                    |
      | <expected_status> | <expected_message>                         |

    Examples:
      | program_title             | expected_status | expected_message                                     |
      | Get Fit & Moving Challenge | Success           | Program deleted successfully                        |
      | Non-Existing Program      | Failure           | Program with title "Non-Existing Program" not found. |

