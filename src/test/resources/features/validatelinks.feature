Feature: Check if all links are working fine for a page


Background:
  Given User launches the browser
  When User navigates to Amazon
  
  @validateLinks
  Scenario: Validate all links are working on homepage
  Then User will check if all the links are working fine on homepage