Feature: Carrers Page Job Duration Check 

Scenario: QA Engineer Job posting's Job Duration 
Given User is on chefhero landing page and naviagtes to Careers Page 
When User clicks on QA Engineer Job Posting
Then Job duration should be "Duration: 6 month contract"
And Close the browser