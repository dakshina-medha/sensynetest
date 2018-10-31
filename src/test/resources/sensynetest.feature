Feature: To do api testing on the application add, update and delete records


  @getproducts
   Scenario: Get products
    When I hit the Get products Api
    Then I should see the available products

  @Add
   Scenario: Add a product
     When I try to add a record with name Alpha and price 20.00
     Then The record should be added


  @Update
  Scenario: Update an existing record
    When I try to update a record with product id 5 and name Alpha and change price to 50.00
    Then The record should be updated

  @Delete
  Scenario: Delete an existing record
    When I try to delete a record with product id 5
    Then The record should be deleted with product id 5