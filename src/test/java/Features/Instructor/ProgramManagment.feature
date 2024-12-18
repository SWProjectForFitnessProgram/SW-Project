Feature: Program Management

  Scenario: Create a fitness program
    Given the instructor is logged in
    When the following details are provided
      | Program title              | Duration | Difficulty level | Goals                  | Content                                                                                                                                                                                                                                                                                                     | Price |
      | Get Fit & Moving Challenge | 30 days  | Beginners        | Weight Loss, Full Body | Video tutorials: [https://youtu.be/f3zOrYCwquE, https://youtu.be/LqW9gdpctKE?list=PLN99XDk2SYr4Vux2b7g04_yKXxpYq6JXp]; Images: [https://plus.unsplash.com/premium_photo-1670505062582-fdaa83c23c9e?q=80&w=1771&auto=format&fit=crop, https://images.unsplash.com/photo-1534438327276-14e5300c3a48?q=80&w=1770&auto=format&fit=crop]; Documentation: [https://www.researchgate.net/publication/342916972_Importance_of_health_and_fitness_in_life] | 29.99 $ |
    Then the program is created with the specified details

  Scenario: Update a fitness program
    Given a fitness program with the title "Get Fit & Moving Challenge" exists
    When the instructor updates the program with the following details
      | Program title              | Duration | Difficulty level | Goals                  | Content                                                                                                                                                                                                                                                                                                     | Price |
      | Get Fit & Moving Challenge | 30 days  | Beginners        | Weight Loss, Full Body | Video tutorials: [https://youtu.be/f3zOrYCwquE, https://youtu.be/LqW9gdpctKE?list=PLN99XDk2SYr4Vux2b7g04_yKXxpYq6JXp]; Images: [https://plus.unsplash.com/premium_photo-1670505062582-fdaa83c23c9e?q=80&w=1771&auto=format&fit=crop, https://images.unsplash.com/photo-1534438327276-14e5300c3a48?q=80&w=1770&auto=format&fit=crop]; Documentation: [https://www.researchgate.net/publication/342916972_Importance_of_health_and_fitness_in_life] | 19.99 $ |
    Then the program is updated successfully with the new details

  Scenario: Update a non-existing fitness program
    Given a fitness program with the title "Get Fit in 30 Days" does not exist
    When the instructor updates the program with the following details
      | Program title              | Duration | Difficulty level | Goals                  | Content                                                                                                                                                                                                                                                                                                     | Price |
      | Get Fit & Moving Challenge | 30 days  | Beginners        | Weight Loss, Full Body | Video tutorials: [https://youtu.be/f3zOrYCwquE, https://youtu.be/LqW9gdpctKE?list=PLN99XDk2SYr4Vux2b7g04_yKXxpYq6JXp]; Images: [https://plus.unsplash.com/premium_photo-1670505062582-fdaa83c23c9e?q=80&w=1771&auto=format&fit=crop, https://images.unsplash.com/photo-1534438327276-14e5300c3a48?q=80&w=1770&auto=format&fit=crop]; Documentation: [https://www.researchgate.net/publication/342916972_Importance_of_health_and_fitness_in_life] | 19.99 $ |
    Then the system displays an error message indicating that the program does not exist

  Scenario: Delete a fitness program
    Given a fitness program with the title "Get Fit & Moving Challenge" exists
    When the instructor chooses to delete the program
    Then the program is deleted successfully

  Scenario: Delete a non-existing fitness program
    Given a fitness program with the title "Get Fit in 30 Days" does not exist
    When the instructor chooses to delete the program
    Then the system displays an error message indicating that the program does not exist
