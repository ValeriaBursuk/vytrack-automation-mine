@smoke
Feature: Adidas feature
  Scenario:
    Given User is on the main page
  When user navigates to "Laptops" and chooses "Sony vaio i5" and clicks on Add to cart and accepts pop up confirmation.
  And navigates to "Laptops" and chooses "Dell i7 8gb" and clicks on Add to cart and accepts pop up confirmation.
  And navigates to Cart Delete "Dell i7 8gb" from cart.
  And clicks on place order.
  And fills in all web form fields.
  And clicks on Purchase button
  And captures and log purchase Id and Amount.
  Then asserts purchase amount equals expected.
  Then Click on Ok