Feature: Search a product and check if product page is working fine


Background:
  Given User launches the browser
  When User navigates to Amazon
  
  @Regression
  Scenario: User searches for iPad
  Given User searches for "iPad"
  When User clicks on any product from the list of products
  Then User will land on that specific product page
  And User will be able to validate the "name" of the product
  And User will be able to validate the "Add to cart" button for that product