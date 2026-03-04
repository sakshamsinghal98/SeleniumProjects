Feature: Amazon Login


Background:
  Given User launches the browser
  When User navigates to Amazon
  
  @smoke
  Scenario: User searches for iPad
  Then User searches for "iPad"

  @smoke
  Scenario: Amazon logo is showing 
  Then User should see amazon logo 
