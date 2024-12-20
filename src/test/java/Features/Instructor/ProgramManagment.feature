Feature: Program Management

  Scenario: Create a fitness program
    Given the instructor is logged in
    When the following details are provided
      |Program title|Get Fit & Moving Challenge|
      |Duration|30 days                        |
      |Difficulty level|Beginners              |
      |Goals           |Weight Loss, Full Body |
      |Content         |https://youtu.be/f3zOrYCwquE |
      |Price|29.99 $                                |
    #  |Schedual time|[5-7]pm                        |

    Then the program is created with the specified details "Get Fit & Moving Challenge"

  Scenario: Update a fitness program Successfully
    Given the instructor is logged in
    When a fitness program with the title "Get Fit & Moving Challenge" exists
    And the instructor updates the program with the following details
      |Program title|Get Fit & Moving Challenge|
      |Duration|3 months                        |
      |Difficulty level|Beginners              |
      |Goals           |Weight Loss, Full Body |
      |Content         |https://youtu.be/f3zOrYCwquE |
      |Price|29.99 $                                |
      #|Schedual time|[5-7]pm                        |
    Then the program is updated successfully with the new details


  Scenario: Update a non-existing fitness program
    Given the instructor is logged in
    When a fitness program with the title "Get Fit" doesn't exist
    And the instructor updates the program with the following details
      |Program title|Get Fit & Moving Challenge|
      |Duration|3 months                        |
      |Difficulty level|Beginners              |
      |Goals           |Weight Loss, Full Body |
      |Content         |https://youtu.be/f3zOrYCwquE |
      |Price|29.99 $                                 |
     # |Schedual time|[5-7]pm                        |
    Then the system displays an error message indicating that the program does not exist

  Scenario Outline: Delete a fitness program (Success and Failure)
    Given the instructor is logged in
    When the instructor attempts to delete the program with title "<program_title>"
    Then the program deletion result is:
      | Status       | Message                                    |
      | <expected_status> | <expected_message>                         |

    Examples:
      | program_title             | expected_status | expected_message                                     |
      | Get Fit & Moving Challenge | Success           | Program deleted successfully                        |
      | Non-Existing Program      | Failure           | Program with title "<program_title>" not found. |

