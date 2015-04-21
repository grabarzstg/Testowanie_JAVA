Scenario: User searches for a single step
 
Given user is on Home page
When user type request in search
Then Find page is shown

Scenario: User choose result from list

Given user is on Find page
When user opens first result
Then Video page is shown