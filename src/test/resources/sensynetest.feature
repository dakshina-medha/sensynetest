Feature: To do api testing on the application add, update and delete records


  @getproducts
   Scenario: Get products
    When I hit the Get products Api
    Then I should see the available products

  @Add
   Scenario: Add a product
     When I try to add a record with name Alpha and price 20.00
     Then The record should be added
