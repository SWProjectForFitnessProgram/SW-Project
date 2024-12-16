Feature: Program Management
  Scenario: create fitness program
    Given instructor logged in
    When the following details given
    | Program title | Duration | Difficulty level | Goals | Content | price
    | Get Fit & Moving Challenge | 30 days | beginners | Weight Loss, Full Body  | Video tutorials: [https://youtu.be/f3zOrYCwquE,https://youtu.be/LqW9gdpctKE?list=PLN99XDk2SYr4Vux2b7g04_yKXxpYq6JXp]; images : [https://plus.unsplash.com/premium_photo-1670505062582-fdaa83c23c9e?q=80&w=1771&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D,https://images.unsplash.com/photo-1534438327276-14e5300c3a48?q=80&w=1770&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D00]; Documentation:[https://www.researchgate.net/publication/342916972_Importance_of_health_and_fitness_in_life];    | 29.99 $
    Then created program with the specified details
